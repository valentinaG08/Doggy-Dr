package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.doggydr.demo.entidad.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
