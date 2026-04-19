package fello.miage.services;


import fello.miage.components.UserComponent;
import fello.miage.mappers.UserMapper;
import fello.miage.requests.UserResquest;
import fello.miage.responses.UserDTO;
import fello.miage.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class UserService {
    private UserComponent userComponent;
    private UserMapper userMapper;



    public UserDTO createUser(UserResquest userResquest) {
        UserEntity userEntity = userMapper.toEntity(userResquest);
        return userMapper.toUserDTO(userComponent.createMembre(userEntity));

    }


}
