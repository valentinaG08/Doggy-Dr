package com.doggydr.demo.servicio;

import java.util.List;

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
    }


    @Override
    public List<Pet> SearchAll() {
        return petRepo.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        petRepo.deleteById(id);
    }

    @Override
    public void update(Pet pet) {
        petRepo.save(pet);
    }

    @Override
    public void add(Pet pet) {
        petRepo.save(pet);
    }


    @Override
    public List<Pet> SearchByClientId(Long id) {
        return petRepo.findByClientId(id);
    }
    
}
