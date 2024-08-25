package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.doggydr.demo.entidad.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
    
}
