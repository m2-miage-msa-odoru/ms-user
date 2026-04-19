package fello.miage.controllers;

import fello.miage.endpoints.MembreEndpoint;
import fello.miage.requests.UserResquest;
import fello.miage.responses.UserDTO;
import fello.miage.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements MembreEndpoint {
    private final UserService userService;


    @Override
    public UserDTO createMembre(UserResquest userResquest) {
        return userService.createUser(userResquest);
    }
}
