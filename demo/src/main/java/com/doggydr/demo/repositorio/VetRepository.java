package com.doggydr.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.doggydr.demo.entidad.Vet;

@Repository
public interface VetRepository extends JpaRepository <Vet, Long> {
    Vet findByDocument(Long document);
    Vet findByUserName(String username);
    Vet findByPassword(String password);
    long countByStatusTrue();
    long countByStatusFalse();
}
