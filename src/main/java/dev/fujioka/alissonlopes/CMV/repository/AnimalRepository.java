package dev.fujioka.alissonlopes.CMV.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.alissonlopes.CMV.model.Animal;


/**
 * @author alisson
 *
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {


}
