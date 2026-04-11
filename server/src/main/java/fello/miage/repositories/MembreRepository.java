package fello.miage.repositories;

import fello.miage.user.MembreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreRepository extends CrudRepository<MembreEntity,String> {
}
