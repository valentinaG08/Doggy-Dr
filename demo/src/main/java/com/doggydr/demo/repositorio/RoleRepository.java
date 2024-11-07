package com.doggydr.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doggydr.demo.entidad.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
