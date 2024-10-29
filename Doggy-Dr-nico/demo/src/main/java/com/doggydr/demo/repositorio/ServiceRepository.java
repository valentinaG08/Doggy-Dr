package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doggydr.demo.entidad.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    
}
