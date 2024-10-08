package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Pet;

public interface PetService {
    public Pet SearchById(Long id);

    public List<Pet> SearchAll();

    public List<Pet> SearchByOwnerId(Long id);

    public void DeleteById(Long id);
    
    public void update(Pet pet);

    public Pet add(Pet pet);
} 