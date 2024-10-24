package com.doggydr.demo.controlador;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.etsi.uri.x01903.v13.ResponderIDType;
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
    public ResponseEntity<List<Treatment>>showTreatments(Model model) {
        
        List<Treatment> lista =  treatmentService.SearchAll();

        ResponseEntity<List<Treatment>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> showTrearment(@PathVariable("id") Long id) {
        
        Treatment treatment = treatmentService.SearchById(id);

        if (treatment == null){
            return new ResponseEntity<Treatment>(treatment, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Treatment>(treatment, HttpStatus.OK);
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> showTrearmentTreatments(@PathVariable("id") Long id) {
        List<Pet> pets = treatmentService.SearchPetsById(id);
        if (pets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pets, HttpStatus.OK);
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
        Treatment savedTreatment = treatmentService.add(treatment); // Guarda el tratamiento
        if (savedTreatment == null) {
            return new ResponseEntity<Treatment>(savedTreatment, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Treatment>(savedTreatment, HttpStatus.CREATED); // Devuelve el tratamiento guardado
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTreatment(@PathVariable("id") Long id) {
            treatmentService.DeleteById(id);
        return new ResponseEntity<>("ELIMINADO", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/vet")
public ResponseEntity<Vet> showPetOwner(@PathVariable("id") Long id) {
    Treatment treatment = treatmentService.SearchById(id);

    // Verificar si el tratamiento existe
    if (treatment == null) {
        return new ResponseEntity<Vet>(HttpStatus.NOT_FOUND);
    }

    // Verificar si el tratamiento tiene un veterinario asociado
    if (treatment.getVet() == null) {
        return new ResponseEntity<Vet>(HttpStatus.NOT_FOUND);
    }

    System.out.println("\n\nVet ID: " + treatment.getVet().getId());

    // Retornar el veterinario asociado al tratamiento
    return new ResponseEntity<Vet>(treatment.getVet(), HttpStatus.OK);
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

        return new ResponseEntity<Treatment>(treatment, HttpStatus.OK);
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
    return new ResponseEntity<Long>(totalTreatments, HttpStatus.OK);
}

@GetMapping("/top3")
public ResponseEntity<List<TreatmentUsageDTO>> getTop3() {
    List<TreatmentUsageDTO> totalTreatments = treatmentService.findTop3Treatments();
    return new ResponseEntity<List<TreatmentUsageDTO>>(totalTreatments, HttpStatus.OK);
}

@GetMapping("/Medicines")
public ResponseEntity<List<TreatmentUsageDTO>> getTreatmentsByMedicine() {
    List<TreatmentUsageDTO> totalTreatments = treatmentService.findTopMedicines();
    return new ResponseEntity<List<TreatmentUsageDTO>>(totalTreatments, HttpStatus.OK); 
}

@GetMapping("/totalSales")
public ResponseEntity<Long> getTotalSales() {
    long totalSales = treatmentService.getTotalSales();
    return new ResponseEntity<Long>(totalSales, HttpStatus.OK);
}

@GetMapping("/totalGains")
public ResponseEntity<Long> getTotalGains() {
    long totalGains = treatmentService.getTotalGains();
    return new ResponseEntity<Long>(totalGains, HttpStatus.OK);
}

}
