package com.doggydr.demo.servicio;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentUsageDTO;

public interface TreatmentService {
    
    public Treatment SearchById(Long id);

    public List<Treatment> SearchAll();

    public Treatment SearchByName(String name);
    
    public List<Treatment> SearchByVetId(Long id);

    public List<Treatment> SearchByPetId(Long id);

    public List<Pet> SearchPetsById(Long id);

    public List<Medicine> SearchMedicinesById(Long id);
    
    public void DeleteById(Long id);

    public void update(Treatment treatment);

    public Treatment add(Treatment treatment);

    public long getTotalTreatments();

    public List<TreatmentUsageDTO> findTop3Treatments();

    public List<TreatmentUsageDTO> findTopMedicines();

    public void associatePetWithTreatment(Long treatmentId, Long petId);
        
    public void associateMedicineWithTreatment(Long treatmentId, Long medicineId);
}
