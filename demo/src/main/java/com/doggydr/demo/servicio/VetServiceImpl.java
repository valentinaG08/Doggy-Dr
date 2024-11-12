package com.doggydr.demo.servicio;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Admin;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.VetRepository;

import io.micrometer.observation.annotation.Observed;

@Service
public class VetServiceImpl implements VetService{
    @Autowired
    VetRepository vetRepo;

    @Override
    public Vet SearchById(Long id) {
        return vetRepo.findById(id).get();
    }

    @Override
    public List<Vet> SearchAll() {
        return vetRepo.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        vetRepo.deleteById(id);
    }

    @Override
    public Vet update(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public Vet add(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public Vet SearchByDocument(Long document) {
        return vetRepo.findByDocument(document);
    }

    @Override
    public Vet findByUserName(String username) {
        return vetRepo.findByUserName(username);
    }

    @Override
    public Vet findByPassword(String password) {
        return vetRepo.findByPassword(password);
    }

    @Override
    public List<Treatment> findTreatmentsByVetId(Long vetId) {
        Vet vet = SearchById(vetId);
        return vet != null ? vet.getTreatments() : null;
    }

    @Override
    public List<Pet> findPetsByVetId(Long vetId) {
        List<Treatment> treatments = findTreatmentsByVetId(vetId);
        List<Pet> pets = new ArrayList<>();
        for (Treatment treatment : treatments) {
            pets.add(treatment.getPet());
        }
        return pets;
    }

    @Override
    public long findAllActives() {
        return vetRepo.countByStatusTrue();
    }

    @Override
    public long findAllInactives() {
        return vetRepo.countByStatusFalse();
    }
}
