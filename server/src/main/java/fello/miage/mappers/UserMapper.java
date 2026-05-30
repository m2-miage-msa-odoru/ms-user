package fello.miage.mappers;

import fello.miage.requests.UserRequest;
import fello.miage.requests.UserUpdateRequest;
import fello.miage.responses.UserDTO;
import fello.miage.modeles.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper
public interface UserMapper {

    UserDTO toUserDTO(UserEntity membreEntity);

    @Mapping(source = "motDePasse", target = "mot_de_passe")
    UserEntity toEntity(UserRequest userRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(UserUpdateRequest request, @MappingTarget UserEntity entity);

    Iterable<UserDTO> toUserDTOs(Iterable<UserEntity> userEntityList);
}