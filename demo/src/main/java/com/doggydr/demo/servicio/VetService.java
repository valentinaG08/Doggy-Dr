package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Admin;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;

public interface VetService {

    public Vet SearchById(Long id);
    
    public List<Vet> SearchAll();

    public void DeleteById(Long id);

    public Vet SearchByDocument(Long document);
    
    public Vet update(Vet vet);

    public Vet add(Vet vet);

    public Vet findByUserName(String username);

    public Vet findByPassword(String password);

    // Método para obtener tratamientos asociados a un veterinario
    List<Treatment> findTreatmentsByVetId(Long vetId);
    
    // Método para obtener mascotas asociadas a un veterinario
    List<Pet> findPetsByVetId(Long vetId);
}
