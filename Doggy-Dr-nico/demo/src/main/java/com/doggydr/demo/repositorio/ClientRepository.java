package com.doggydr.demo.repositorio;

import com.doggydr.demo.entidad.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
    // Método personalizado para buscar un cliente por nombre de usuario
    Client findByUsername(String username);
    Client findByDocument(Long document);
    
}
