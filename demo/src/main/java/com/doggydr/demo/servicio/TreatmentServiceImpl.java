package com.doggydr.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Collection<Treatment> SearchAll() {
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

}
