package com.doggydr.demo.servicio;

import java.util.List;
import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Treatment;

public interface MedicineService {

    public List<Medicine> SearchAll();

    public Medicine SearchById(Long id);

    public Medicine SearchByName(String name);
    
    public void DeleteById(Long id);

    public void update(Medicine medicine);

    public void add(Medicine medicine);

    public List<Treatment> SearchTreatmentsById(Long id);
    
    public void soldMedicine(Long id);
}
