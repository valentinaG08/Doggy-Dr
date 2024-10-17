package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;

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

    public void add(Treatment treatment);
}
