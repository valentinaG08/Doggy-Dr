package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doggydr.demo.entidad.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
    Treatment findByName(String name);
}
