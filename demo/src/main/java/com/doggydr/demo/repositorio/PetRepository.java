package com.doggydr.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.doggydr.demo.entidad.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
    List<Pet> findByOwnerId(Long id);
}
