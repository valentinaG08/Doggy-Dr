package com.doggydr.demo.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Pet;

public interface PetService {
    public Pet SearchById(int id);

    public Collection<Pet> SearchAll();

    public void deleteById(int id);
    
    public void update(Pet pet);

    public void add(Pet pet);
} 