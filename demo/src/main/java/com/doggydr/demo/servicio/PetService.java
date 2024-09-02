package com.doggydr.demo.servicio;

import java.util.Collection;
import com.doggydr.demo.entidad.Pet;

public interface PetService {
    public Pet SearchById(Long id);

    public Collection<Pet> SearchAll();

    public void DeleteById(Long id);
    
    public void update(Pet pet);

    public void add(Pet pet);
} 