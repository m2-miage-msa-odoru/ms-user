package fello.miage.components;

import fello.miage.enums.RoleMembre;
import fello.miage.exceptions.technical.UserNotFoundException;
import fello.miage.repositories.UserRepository;
import fello.miage.modeles.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.List;


@Component
@RequiredArgsConstructor
public class UserComponent {

    private final UserRepository userRepository;

    public UserEntity createMembre(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity getUserById(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("Utilisateur non trouvée pour la référence : [%s]" ,email)));

    }

    public UserEntity updateUser(String email, RoleMembre roleMembre, int niveau_expertise) throws UserNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + email));

        return userRepository.save(user);
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
