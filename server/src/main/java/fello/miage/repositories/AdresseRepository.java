package fello.miage.repositories;

import fello.miage.modeles.AdresseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<AdresseEntity,String> {
}
