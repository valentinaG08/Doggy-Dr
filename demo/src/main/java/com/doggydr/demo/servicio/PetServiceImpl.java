package com.doggydr.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.repositorio.PetRepository;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetRepository petRepo;

    @Override
    public Pet SearchById(Long id) {
        return petRepo.findById(id).get();
        // TODO Auto-generated method stub
    }

    @Override
    public Collection<Pet> SearchAll() {
        return petRepo.findAll();
        // TODO Auto-generated method stub
    }

    @Override
    public void DeleteById(Long id) {
        // TODO Auto-generated method stub
        petRepo.deleteById(id);
    }

    @Override
    public void update(Pet pet) {
        // TODO Auto-generated method stub
        petRepo.save(pet);
    }

    @Override
    public void add(Pet pet) {
        // TODO Auto-generated method stub
        petRepo.save(pet);
    }
    
}
