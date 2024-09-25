package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doggydr.demo.entidad.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
    Medicine findByName(String name);
}

