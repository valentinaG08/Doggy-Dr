package com.doggydr.demo.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doggydr.demo.entidad.*;
import com.doggydr.demo.servicio.PetService;
import com.doggydr.demo.servicio.TreatmentService;
import com.doggydr.demo.servicio.VetService;

@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {

    @Autowired
    PetService petService;

    @Autowired
    VetService vetService;

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Treatment>> showTreatments() {
        List<Treatment> lista = treatmentService.SearchAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> showTrearment(@PathVariable("id") Long id) {
        Treatment treatment = treatmentService.SearchById(id);
        if (treatment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(treatment, HttpStatus.OK);
    }

    @GetMapping("/{id}/pet")
    public ResponseEntity<Pet> showTrearmentTreatments(@PathVariable("id") Long id) {
        Pet pet = treatmentService.SearchPetById(id);
        if (pet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/{id}/medicines")
    public ResponseEntity<List<Medicine>> showTrearmentMedicines(@PathVariable("id") Long id) {
        List<Medicine> medicines = treatmentService.SearchMedicinesById(id);
        if (medicines == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment treatment) {
        Treatment savedTreatment = treatmentService.add(treatment);
        if (savedTreatment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedTreatment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteTreatment(@PathVariable("id") Long id) {
        treatmentService.DeleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "ELIMINADO");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/vet")
    public ResponseEntity<Vet> showPetOwner(@PathVariable("id") Long id) {
        Treatment treatment = treatmentService.SearchById(id);
        if (treatment == null || treatment.getVet() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(treatment.getVet(), HttpStatus.OK);
    }

    @PutMapping("/{treatmentId}/associate/vet/{vetId}")
    public ResponseEntity<Treatment> associateTreatmentWithVet(@PathVariable Long treatmentId, @PathVariable Long vetId) {
        Vet vet = vetService.SearchById(vetId);
        Treatment treatment = treatmentService.SearchById(treatmentId);

        if (vet == null || treatment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        treatment.setVet(vet);
        treatmentService.update(treatment);
        return new ResponseEntity<>(treatment, HttpStatus.OK);
    }

    @PutMapping("/{treatmentId}/associate/medicine/{medicineId}")
    public ResponseEntity<Map<String, String>> associateMedicineWithTreatment(@PathVariable Long treatmentId, @PathVariable Long medicineId) {
        try {
            treatmentService.associateMedicineWithTreatment(treatmentId, medicineId);
            return ResponseEntity.ok(new HashMap<>()); // JSON vacío como respuesta exitosa
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping("/{treatmentId}/associate/pet/{petId}")
    public ResponseEntity<Map<String, String>> associatePetWithTreatment(@PathVariable Long treatmentId, @PathVariable Long petId) {
        try {
            treatmentService.associatePetWithTreatment(treatmentId, petId);
            return ResponseEntity.ok(new HashMap<>()); // JSON vacío como respuesta exitosa
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalTreatments() {
        long totalTreatments = treatmentService.getTotalTreatments();
        return new ResponseEntity<>(totalTreatments, HttpStatus.OK);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<TreatmentUsageDTO>> getTop3() {
        List<TreatmentUsageDTO> totalTreatments = treatmentService.findTop3Treatments();
        return new ResponseEntity<>(totalTreatments, HttpStatus.OK);
    }

    @GetMapping("/Medicines")
    public ResponseEntity<List<TreatmentUsageDTO>> getTreatmentsByMedicine() {
        List<TreatmentUsageDTO> totalTreatments = treatmentService.findTopMedicines();
        return new ResponseEntity<>(totalTreatments, HttpStatus.OK); 
    }

    @GetMapping("/totalSales")
    public ResponseEntity<Long> getTotalSales() {
        long totalSales = treatmentService.getTotalSales();
        return new ResponseEntity<>(totalSales, HttpStatus.OK);
    }

    @GetMapping("/totalGains")
    public ResponseEntity<Long> getTotalGains() {
        long totalGains = treatmentService.getTotalGains();
        return new ResponseEntity<>(totalGains, HttpStatus.OK);
    }
}
