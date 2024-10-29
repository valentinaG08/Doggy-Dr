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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.servicio.VetService;
import com.doggydr.demo.servicio.TreatmentService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {
    
    @Autowired
    VetService vetService;
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/all")
    public List<Vet> showVets(Model model) {
        return vetService.SearchAll();
    }

    @GetMapping("/find")
    public Vet mostrarInfoVet(@RequestParam("id") Long id){
        return vetService.SearchById(id);
    }

    @GetMapping("/find/{id}")
    public Vet mostrarInfoVet2(@PathVariable("id") Long id){
        Vet vet = vetService.SearchById(id);
        return vet;
    }

    @GetMapping("/add")
    public String showAddForms(Model model) {
        Vet vet = new Vet();
        model.addAttribute("veterinario", vet);
        return "createVet";
    }

    @PostMapping("/add")
    public ResponseEntity<Vet> agregarVeterinario(@RequestBody Vet vet) {
        System.out.println("\n\nVeterinario recibido: " + vet);

        if (vet == null) {
            return ResponseEntity.badRequest().build(); // Retorna error si vet es null
        }

        // Si llegamos aquí, significa que vet no es null, así que puede proceder a guardarla
        Vet savedVet = vetService.add(vet); // Guarda el veterinario en la base de datos
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVet); // Retorna el objeto guardado
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVet(@PathVariable("id") Long identification){
        vetService.DeleteById(identification);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Vet> updateVet(@PathVariable("id") Long id, @RequestBody Vet vet) {
        
        if (vet == null || !vet.getId().equals(id)) {
            System.out.println("\n\nVeterinario recibido: " + vet.getId());
            return ResponseEntity.badRequest().build(); // Retorna un error si el ID no coincide
        }

        List<Treatment> treatments  = treatmentService.SearchByVetId(id);

        vet.setTreatments(treatments);

        Vet updatedVet = vetService.update(vet);
        return ResponseEntity.ok(updatedVet);
    }

    @GetMapping("/{id}/treatments")
    public List<Treatment> showTreatmentsbyVet(@PathVariable("id") Long id) {
        Vet vet = vetService.SearchById(id);
        System.out.println("\n\n Treatments: " + vet.getTreatments().size());
        return vet.getTreatments();
    } 

    @GetMapping("/{id}/pets")
    public List<Pet> showPetsbyVet(@PathVariable("id") Long id) {
        List<Pet> pets = vetService.findPetsByVetId(id);
        System.out.println("\n\n Pets: " + pets.size());

        return pets;
    } 
    
    @GetMapping("/active")
    public ResponseEntity<Long> getActiveVeterinarians() {
        long totalVets = vetService.findAllActives();
        return ResponseEntity.ok(totalVets);
    }

    @GetMapping("/inactive")
    public ResponseEntity<Long> getInactiveVeterinarians() {
        long totalVets = vetService.findAllInactives();
        return ResponseEntity.ok(totalVets);
    }
}
