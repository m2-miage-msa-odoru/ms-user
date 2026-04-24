package fello.miage.repositories;

import fello.miage.modeles.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
