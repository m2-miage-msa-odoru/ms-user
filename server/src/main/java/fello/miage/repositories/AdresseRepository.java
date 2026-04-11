package fello.miage.repositories;

import fello.miage.user.AdressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<AdressEntity,String> {
}
