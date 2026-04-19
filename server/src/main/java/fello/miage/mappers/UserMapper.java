package fello.miage.mappers;

import fello.miage.requests.UserResquest;
import fello.miage.responses.UserDTO;
import fello.miage.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(UserEntity membreEntity);

    UserEntity toEntity(UserResquest userResquest);
}