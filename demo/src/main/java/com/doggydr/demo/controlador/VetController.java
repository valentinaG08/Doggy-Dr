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
import com.doggydr.demo.servicio.VetService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {
    
    @Autowired
    VetService vetService;

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
            return ResponseEntity.badRequest().build(); // Retorna error si pet es null
        }

        // Si llegamos aquí, significa que pet no es null, así que puede proceder a guardarla
        Vet savedVet = vetService.add(vet); // Guarda la mascota en la base de datos
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVet); // Retorna el objeto guardado
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVet(@PathVariable("id") Long identification){
        vetService.DeleteById(identification);
    }

    @PutMapping("/update/{id}")
    public Vet updateVet(@PathVariable("id") Long id, @RequestBody Vet vet){
        System.out.println("\n\nRecibido para actualizar: " + vet.getName() + " id: " + vet.getId());
        
        //Verificar que exista antes de actualizar
        if (vet == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veterinario no encontrado");
        }

        // Guarda el veterinario actualizada
        vetService.update(vet);

        // Devuelve el veterinario actualizada
        return vet;

    }
}
