package fello.miage.services;


import fello.miage.components.MembreComponent;
import fello.miage.mappers.MembreMapper;
import fello.miage.requests.MembreResquest;
import fello.miage.responses.MembreDTO;
import fello.miage.user.MembreEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class MembreService {
    private MembreComponent membreComponent;
    private MembreMapper membreMapper;



    public MembreDTO createMembre(MembreResquest membreResquest) {
        MembreEntity membreEntity = membreMapper.toEntity(membreResquest);
        return membreMapper.toMembreDTO(membreComponent.createMembre(membreEntity));

    }


}
