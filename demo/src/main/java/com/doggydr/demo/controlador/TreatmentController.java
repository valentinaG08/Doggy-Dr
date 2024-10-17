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
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;
import com.doggydr.demo.servicio.TreatmentService;

@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {

    @Autowired
    PetService petService;
    
    @Autowired
    ClientService clientService;

    @Autowired
    TreatmentService treatmentService;
    
    @GetMapping("/all")
    public List<Treatment> showPets(Model model){
        return treatmentService.SearchAll();
    }

    @GetMapping("/{id}/pets")
    public List<Pet> showTrearmentPets(@PathVariable("id") Long id){
        return treatmentService.SearchPetsById(id);
    }

    @GetMapping("/{id}/medicines")
    public List<Medicine> showTrearmentMedicines(@PathVariable("id") Long id){
        return treatmentService.SearchMedicinesById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Treatment newTreatment) {
        System.out.println("\n\nTreatment recibido: " + newTreatment.getName());

        treatmentService.add(newTreatment);
    }
}
