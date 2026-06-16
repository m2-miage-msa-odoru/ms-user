package fello.miage.controllers;

import fello.miage.endpoints.UserEndpoint;
import fello.miage.enums.RoleMembre;
import fello.miage.requests.LoginRequest;
import fello.miage.requests.UserRequest;
import fello.miage.requests.UserUpdateRequest;
import fello.miage.responses.UserDTO;
import fello.miage.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserEndpoint {
    private final UserService userService;


    @Override
    public UserDTO createMembre(UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    /**
     * Mise à jour d'un adhérent — réservée à la SECRETAIRE (son rôle est vérifié dans le service).
     */
    @Override
    public UserDTO updateMembre(String email, String secretaireEmail, RoleMembre roleMembre, int niveau_expertise) {
        return userService.updateUser(email, secretaireEmail, roleMembre, niveau_expertise);
    }

    /**
     * @return
     */
    @Override
    public Iterable<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDTO login(LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @Override
    public UserDTO getMembreByEmail(String email) {
        return userService.getUserByEmail(email);
    }
}
