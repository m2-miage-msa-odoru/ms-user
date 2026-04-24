package fello.miage.controllers;

import fello.miage.endpoints.UserEndpoint;
import fello.miage.enums.RoleMembre;
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
     * @param email
     * @param  roleMembre, niveau_expertise
     * @return
     */
    @Override
    public UserDTO updateMembre(String email, RoleMembre roleMembre,int niveau_expertise) {
        return userService.updateUser(email, roleMembre, niveau_expertise);
    }

    /**
     * @return
     */
    @Override
    public Iterable<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
