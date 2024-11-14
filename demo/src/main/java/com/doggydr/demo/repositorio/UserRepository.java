package com.doggydr.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doggydr.demo.entidad.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional<UserEntity> findByUsername(String userName);
    Boolean existsByUsername(String userName);
    Boolean existsByDocument(Long document);
    Optional<UserEntity> findByDocument(Long document);
}
