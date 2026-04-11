package fello.miage.controllers;

import fello.miage.endpoints.MembreEndpoint;
import fello.miage.requests.MembreResquest;
import fello.miage.responses.MembreDTO;
import fello.miage.services.MembreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembreController implements MembreEndpoint {
    private final MembreService membreService;


    @Override
    public MembreDTO createMembre(MembreResquest membreResquest) {
        return membreService.createMembre(membreResquest);
    }
}
