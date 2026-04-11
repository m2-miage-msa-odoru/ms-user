package fello.miage.components;

import fello.miage.repositories.MembreRepository;
import fello.miage.responses.MembreDTO;
import fello.miage.services.MembreService;
import fello.miage.user.MembreEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MembreComponent {

    private final MembreRepository membreRepository;

    public MembreEntity createMembre(MembreEntity membreEntity) {
        return membreRepository.save(membreEntity);
    }
}
