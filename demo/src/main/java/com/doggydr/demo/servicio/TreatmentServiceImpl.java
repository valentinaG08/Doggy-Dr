package com.doggydr.demo.servicio;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.repositorio.TreatmentRepository;

@Service
public class TreatmentServiceImpl implements TreatmentService{
    
    @Autowired
    TreatmentRepository treatmentRepo;

    @Override
    public Treatment SearchById(Long id) {
        return treatmentRepo.findById(id).get();
    }

    @Override
    public List<Treatment> SearchAll() {
        return treatmentRepo.findAll();
    }

    @Override
    public Treatment SearchByName(String name) {
        return treatmentRepo.findByName(name);
    }

    @Override
    public void DeleteById(Long id) {
        treatmentRepo.deleteById(id);
    }

    @Override
    public void update(Treatment treatment) {
        treatmentRepo.save(treatment);
    }

    @Override
    public void add(Treatment treatment) {
        treatmentRepo.save(treatment);
    }

    @Override
    public List<Treatment> SearchByVetId(Long id) {
        return treatmentRepo.findByVetId(id);
    }

    @Override
    public List<Treatment> SearchByPetId(Long id) {
        return treatmentRepo.findByPetsId(id);
    }

    @Override
    public List<Pet> SearchPetsById(Long id) {
        return treatmentRepo.findPetsById(id);
    }

    @Override
    public List<Medicine> SearchMedicinesById(Long id) {
        return treatmentRepo.findMedicinesById(id);
    }
}
