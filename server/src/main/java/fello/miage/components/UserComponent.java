package fello.miage.components;

import fello.miage.repositories.UserRepository;
import fello.miage.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserComponent {

    private final UserRepository userRepository;

    public UserEntity createMembre(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
