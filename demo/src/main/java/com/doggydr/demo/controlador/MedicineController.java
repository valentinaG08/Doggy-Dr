package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
