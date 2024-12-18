package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.doggydr.demo.DTOs.VetDTO;
import com.doggydr.demo.DTOs.VetMapper;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.UserRepository;
import com.doggydr.demo.security.CustomUserDetailService;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.UserEntity;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @GetMapping("/all")
    public List<Vet> showVets(Model model) {
        return vetService.SearchAll();
    }

    @GetMapping("/find")
    public Vet mostrarInfoVet(@RequestParam("id") Long id) {
        return vetService.SearchById(id);
    }

    @GetMapping("/find/{id}")
    public Vet mostrarInfoVet2(@PathVariable("id") Long id) {
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
    public ResponseEntity agregarVeterinario(@RequestBody Vet vet) {
        /*
         * System.out.println("\n\nVeterinario recibido: " + vetDTO);
         * 
         * if (vetDTO == null) {
         * return ResponseEntity.badRequest().build(); // Retorna error si vetDTO es
         * null
         * }
         * 
         * // Crear entidad Vet usando los datos de VetDTO
         * Vet vet = new Vet();
         * vet.setName(vetDTO.getName());
         * vet.setMail(vetDTO.getMail());
         * 
         * // Guardar el veterinario en la base de datos
         * Vet savedVet = vetService.add(vet);
         * 
         * // Convertir el Vet guardado a VetDTO para la respuesta
         * VetDTO savedVetDTO = VetMapper.INSTANCE.convert(savedVet);
         * 
         * return ResponseEntity.status(HttpStatus.CREATED).body(savedVetDTO);
         */
        if (userRepository.existsByUsername(vet.getMail())) {
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        Vet VetDB = vetService.add(vet);
        VetDTO newVetDTO = VetMapper.INSTANCE.convert(VetDB);

        if (newVetDTO == null) {
            return new ResponseEntity<VetDTO>(newVetDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<VetDTO>(newVetDTO, HttpStatus.CREATED);

    }

    @GetMapping("/details")
    public ResponseEntity<?> buscarVeterinario() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (username == null || username.isEmpty()) {
            return new ResponseEntity<>("No se pudo obtener el nombre de usuario", HttpStatus.UNAUTHORIZED);
        }

        Vet vet = vetService.findByUserName(username);

        if (vet == null) {
            return new ResponseEntity<>("Veterinario no encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVet(@PathVariable("id") Long identification) {
        System.out.println( "\nidentification eliminar veterinario: " + identification);

        try {

            vetService.DeleteById(identification);
            return ResponseEntity.ok("veterinario eliminado exitosamente");

        } catch (DataIntegrityViolationException e) {

            System.out.println( "\nError eliminar veterinario: No se puede eliminar el veterinario porque tiene relaciones asociadas. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar el veterinario porque tiene relaciones asociadas.");
        
        } catch (Exception e) {

            System.out.println( "\nError eliminar veterinario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el veterinario: " + e.getMessage());
            
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vet> updateVet(@PathVariable("id") Long id, @RequestBody Vet vet) {

        if (vet == null || !vet.getId().equals(id)) {
            System.out.println("\n\nVeterinario recibido: " + vet.getId());
            return ResponseEntity.badRequest().build(); // Retorna un error si el ID no coincide
        }

        List<Treatment> treatments = treatmentService.SearchByVetId(id);

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
