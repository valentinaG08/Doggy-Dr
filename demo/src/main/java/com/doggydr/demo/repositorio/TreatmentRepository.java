package com.doggydr.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
    Treatment findByName(String name);
    List<Treatment> findByVetId(Long id);

    List<Treatment> findByPetsId(Long id);
    
    @Query("SELECT p FROM Pet p JOIN p.treatments t WHERE t.id = :treatmentId")
    List<Pet> findPetsById(@Param("treatmentId") Long treatmentId);

    @Query("SELECT m FROM Medicine m JOIN m.treatments t WHERE t.id = :treatmentId")
    List<Medicine> findMedicinesById(@Param("treatmentId") Long treatmentId);
}
