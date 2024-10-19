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
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
    Medicine findByName(String name);
    
    List<Treatment> findTreatmentsById(Long id);
}

