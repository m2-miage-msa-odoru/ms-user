package fello.miage.mappers;

import fello.miage.requests.MembreResquest;
import fello.miage.responses.MembreDTO;
import fello.miage.user.MembreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MembreMapper {

    MembreDTO toMembreDTO(MembreEntity membreEntity);

    MembreEntity toEntity(MembreResquest membreResquest);
}