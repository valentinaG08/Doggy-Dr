package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.servicio.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/all")
    public List<Medicine> showMedicines(Model model){
        return medicineService.SearchAll();
    }
    
    @GetMapping("/{id}")
    public Medicine showMedicine(@PathVariable("id") Long id){
        return medicineService.SearchById(id);
    }

    @GetMapping("/{id}/treatments")
    public List<Treatment> showMedicineTreatments(@PathVariable("id") Long id){
        return medicineService.SearchTreatmentsById(id);
    }

    @PutMapping("/update/{id}")
    public Medicine updatePet(@PathVariable("id") Long id, @RequestBody Medicine medicine) {
        
        System.out.println("\n\nRecibido para actualizar: " + medicine.getName() + " id: " + medicine.getId());
        
        // Guarda la mascota actualizada
        medicineService.update(medicine);

        // Devuelve la mascota actualizada
        return medicine;
    }

}
