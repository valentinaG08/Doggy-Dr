package com.doggydr.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentPet;

@Repository
public interface TreatmentPetRepository extends JpaRepository<TreatmentPet, Long>{

    long count();
    
@Query(value = "SELECT TREATMENT_ID, COUNT(*) AS num_uses " +
               "FROM TREATMENT_PET " +
               "GROUP BY TREATMENT_ID " +
               "ORDER BY num_uses DESC " +
               "LIMIT 3", nativeQuery = true)
List<Object[]> findTop3Treatments();
}
