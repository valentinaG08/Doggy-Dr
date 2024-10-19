package com.doggydr.demo.servicio;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentUsageDTO;
import com.doggydr.demo.repositorio.TreatmentRepository;
import com.doggydr.demo.repositorio.TreatmentPetRepository;
import com.doggydr.demo.repositorio.MedicineRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.TreatmentMedicineRepository;

@Service
public class TreatmentServiceImpl implements TreatmentService{
    
    @Autowired
    TreatmentRepository treatmentRepo;

    @Autowired
    PetRepository petRepo;

    @Autowired
    MedicineRepository medicineRepo;

    @Autowired
    TreatmentPetRepository treatmentPetRepo;

    @Autowired
    TreatmentMedicineRepository treatmentMedicineRepo;

    @Override
    public Treatment SearchById(Long id) {
        return treatmentRepo.findById(id).orElseThrow(() -> 
            new RuntimeException("Tratamiento no encontrado con ID: " + id)
        );
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
    public Treatment add(Treatment treatment) {
        return treatmentRepo.save(treatment);
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

    
    @Override
    public long getTotalTreatments() {
        return treatmentPetRepo.count();
    }

    @Override
    public List<TreatmentUsageDTO> findTop3Treatments() {
        List<Object[]> results = treatmentPetRepo.findTop3Treatments();
        List<TreatmentUsageDTO> topTreatments = new ArrayList<>();

        for (Object[] result : results) {
            Long treatmentId = ((Number) result[0]).longValue();  // Obtener TREATMENT_ID
            Long numUses = ((Number) result[1]).longValue();  // Obtener num_uses
            topTreatments.add(new TreatmentUsageDTO(treatmentId, numUses));
        }

        return topTreatments;
    }

    @Override
    public List<TreatmentUsageDTO> findTopMedicines() {
        List<Object[]> results = treatmentMedicineRepo.findTopMedicines();
        List<TreatmentUsageDTO> topTreatments = new ArrayList<>();

        for (Object[] result : results) {
            Long treatmentId = ((Number) result[0]).longValue();  // Obtener TREATMENT_ID
            Long numUses = ((Number) result[1]).longValue();  // Obtener num_uses
            topTreatments.add(new TreatmentUsageDTO(treatmentId, numUses));
        }

        return topTreatments;
    }

    @Override
    public void associatePetWithTreatment(Long treatmentId, Long petId) {
        Treatment treatment = treatmentRepo.findById(treatmentId)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con ID: " + treatmentId));

        Pet pet = petRepo.findById(petId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + petId));

        treatment.getPets().add(pet); // Asocia la mascota al tratamiento
        treatmentRepo.save(treatment); // Guarda los cambios
    }

    @Override
    public void associateMedicineWithTreatment(Long treatmentId, Long medicineId) {
        Treatment treatment = treatmentRepo.findById(treatmentId)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con ID: " + treatmentId));

        Medicine medicine = medicineRepo.findById(medicineId)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con ID: " + medicineId));

        treatment.getMedicines().add(medicine); // Asocia el medicamento al tratamiento
        treatmentRepo.save(treatment); // Guarda los cambios
    }

}


