package com.doggydr.demo.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.repositorio.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{
    
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public List<Medicine> SearchAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine SearchById(Long id) {
        return medicineRepository.findById(id).get();
    }

    @Override
    public Medicine SearchByName(String name) {
        return medicineRepository.findByName(name);
    }
    
    @Override
    public void DeleteById(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public void update(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public void add(Medicine medicine) {
        medicineRepository.save(medicine);
    }
}
