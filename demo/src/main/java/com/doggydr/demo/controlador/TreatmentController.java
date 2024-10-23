package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentUsageDTO;
import com.doggydr.demo.entidad.Vet;
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
    public List<Treatment> showTreatments(Model model) {
        return treatmentService.SearchAll();
    }

    @GetMapping("/{id}")
    public Treatment showTrearment(@PathVariable("id") Long id) {
        return treatmentService.SearchById(id);
    }

    @GetMapping("/{id}/pets")
    public List<Pet> showTrearmentTreatments(@PathVariable("id") Long id) {
        return treatmentService.SearchPetsById(id);
    }

    @GetMapping("/{id}/medicines")
    public List<Medicine> showTrearmentMedicines(@PathVariable("id") Long id) {
        return treatmentService.SearchMedicinesById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment treatment) {
        Treatment savedTreatment = treatmentService.add(treatment); // Guarda el tratamiento
        return ResponseEntity.ok(savedTreatment); // Devuelve el tratamiento guardado
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable("id") Long id) {
        try {
            treatmentService.DeleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve un 204 No Content si se elimina correctamente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Maneja cualquier error
        }
    }

    @GetMapping("/{id}/vet")
    public Vet showPetOwner(@PathVariable("id") Long id) {
        Treatment treatment = treatmentService.SearchById(id);

        System.out.println("\n\nTreatment ID: " + treatment.getVet().getId());

        return treatment.getVet();
    }

    @PutMapping("/{treatmentId}/associate/{vetId}")
    public ResponseEntity<Treatment> associateTreatmentWithVet(@PathVariable Long treatmentId, @PathVariable Long vetId) {
        System.out.println("\n\nTreatment ID: " + treatmentId);
        System.out.println("\n\nVet ID: " + vetId);

        // Buscar el veterinario por vetId
        Vet vet = vetService.SearchById(vetId);
        if (vet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Veterinario no encontrado
        }
        System.out.println("\n\nVet Name: " + vet.getName());

        // Buscar el tratamiento por treatmentId
        Treatment treatment = treatmentService.SearchById(treatmentId);
        if (treatment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Tratamiento no encontrado
        }
        System.out.println("\n\nTreatment name: " + treatment.getName());

        // Asociar el veterinario al tratamiento
        treatment.setVet(vet);
        treatmentService.update(treatment); // Asegúrate de que este método actualiza el tratamiento en la base de datos

        return ResponseEntity.ok(treatment);
    }

    @PutMapping("/{treatmentId}/associate/medicine/{medicineId}")
    public ResponseEntity<?> associateMedicineWithTreatment(@PathVariable Long treatmentId, @PathVariable Long medicineId) {
        try {
            treatmentService.associateMedicineWithTreatment(treatmentId, medicineId);
            return ResponseEntity.ok("Medicamento asociado correctamente al tratamiento.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{treatmentId}/associate/pet/{petId}")
    public ResponseEntity<?> associatePetWithTreatment(@PathVariable Long treatmentId, @PathVariable Long petId) {
        try {
            treatmentService.associatePetWithTreatment(treatmentId, petId);
            return ResponseEntity.ok("Mascota asociada correctamente al tratamiento.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalTreatments() {
        long totalTreatments = treatmentService.getTotalTreatments();
        return ResponseEntity.ok(totalTreatments);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<TreatmentUsageDTO>> getTop3() {
        List<TreatmentUsageDTO> totalTreatments = treatmentService.findTop3Treatments();
        return ResponseEntity.ok(totalTreatments);
    }
    @GetMapping("/Medicines")
    public ResponseEntity<List<TreatmentUsageDTO>> getTreatmentsByMedicine() {
        List<TreatmentUsageDTO> totalTreatments = treatmentService.findTopMedicines();
        return ResponseEntity.ok(totalTreatments);
    }

    @GetMapping("/totalSales")
    public ResponseEntity<Long> getTotalSales() {
        long totalSales = treatmentService.getTotalSales();
        return ResponseEntity.ok(totalSales);
    }

    @GetMapping("/totalGains")
    public ResponseEntity<Long> getTotalGains() {
        long totalGains = treatmentService.getTotalGains();
        return ResponseEntity.ok(totalGains);
    }
}
