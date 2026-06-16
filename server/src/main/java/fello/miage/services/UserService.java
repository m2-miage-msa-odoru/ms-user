package fello.miage.services;

import fello.miage.components.UserComponent;
import fello.miage.enums.RoleMembre;
import fello.miage.exceptions.rest.BadRequestRestException;
import fello.miage.exceptions.rest.ForbiddenRestException;
import fello.miage.exceptions.technical.UserNotFoundException;
import fello.miage.mappers.UserMapper;
import fello.miage.messaging.producer.RabbitMQProducer;
import fello.miage.requests.LoginRequest;
import fello.miage.requests.UserRequest;
import fello.miage.requests.UserUpdateRequest;
import fello.miage.responses.UserDTO;
import fello.miage.modeles.UserEntity;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class UserService {
    private UserComponent userComponent;
    private UserMapper userMapper;
    private RabbitMQProducer rabbitMQProducer;

    public UserDTO createUser(UserRequest userRequest) {
        try {
            UserEntity userEntity = userMapper.toEntity(userRequest);
            userEntity.setRole(RoleMembre.ADHERENT);
            userEntity.setNiveau_expertise(1);
            UserEntity saved = userComponent.createMembre(userEntity);
            rabbitMQProducer.publishUserRegistered(saved);
            return userMapper.toUserDTO(saved);
        } catch (Exception e) {
            throw new BadRequestRestException(e.getMessage());
        }
    }

    public UserDTO updateUser(String email, String secretaireEmail, RoleMembre roleMembre, int niveau_expertise){
        // Seule une SECRETAIRE est autorisée à modifier un adhérent.
        // Vérification effectuée AVANT le try afin de préserver le code HTTP 403.
        UserEntity secretaire;
        try {
            secretaire = userComponent.getUserById(secretaireEmail);
        } catch (UserNotFoundException e) {
            throw new ForbiddenRestException("Secrétaire introuvable : " + secretaireEmail);
        }
        if (secretaire.getRole() != RoleMembre.SECRETAIRE) {
            throw new ForbiddenRestException(
                    "Seule une SECRETAIRE peut modifier un adhérent. Rôle de " + secretaireEmail + " : " + secretaire.getRole());
        }

        try {
            UserEntity userEntity = userComponent.getUserById(email);
            int ancienNiveauExpertise = userEntity.getNiveau_expertise();

            if (niveau_expertise != 0) {
                userEntity.setNiveau_expertise(niveau_expertise);
            }
            if (roleMembre != null) {
                userEntity.setRole(roleMembre);
            }

            UserEntity updatedUser = userComponent.updateUser(userEntity);

            if (niveau_expertise != 0 && ancienNiveauExpertise != niveau_expertise) {
                rabbitMQProducer.publishExpertiseUpdated(updatedUser, ancienNiveauExpertise);
            }

            return userMapper.toUserDTO(updatedUser);
        } catch (Exception e) {
            throw new BadRequestRestException(e.getMessage());
        }
    }

    public Iterable<UserDTO> getAllUsers(){
        try {
            Iterable<UserEntity> userEntities = userComponent.getUsers();
            return userMapper.toUserDTOs(userEntities);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

    }

    public UserDTO login(LoginRequest loginRequest) {
        try {
            UserEntity user = userComponent.getUserById(loginRequest.getEmail());
            if (!user.getMot_de_passe().equals(loginRequest.getMotDePasse())) {
                throw new BadRequestRestException("Email ou mot de passe incorrect");
            }
            return userMapper.toUserDTO(user);
        } catch (Exception e) {
            throw new BadRequestRestException("Email ou mot de passe incorrect");
        }
    }

    public UserDTO getUserByEmail(String email) {
        try {
            UserEntity user = userComponent.getUserById(email);
            return userMapper.toUserDTO(user);
        } catch (Exception e) {
            throw new BadRequestRestException("Membre introuvable : " + email);
        }
    }
}