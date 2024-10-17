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
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {

    @Autowired
    PetService petService;
    
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Pet> showPets(Model model){
        //model.addAttribute("mascotas", petService.SearchAll());
        //return "show_all_pets";
        return petService.SearchAll();
    }

    @GetMapping("/find/{id}")
    public Pet showInfoPet(@PathVariable("id") Long identification){
        //model.addAttribute("pet", petService.SearchById(identification));
        //return "show_pet";
        Pet pet = petService.SearchById(identification);
        return pet;
    }

    @GetMapping("/{id}/owner")
    public Client showPetOwner(@PathVariable("id") Long identification){
        Pet pet = petService.SearchById(identification);
        return pet.getOwner();
    }

    @GetMapping("/{id}/treatments")
    public List<Treatment> showTreatmentsbyPet(@PathVariable("id") Long id) {
        Pet pet = petService.SearchById(id);
        System.out.println("\n\n Treatments: " + pet.getTreatments().size());
        return pet.getTreatments();
    } 

    /*@GetMapping("/client/{id}/pets")
    public List<Pet> showClientPets(@PathVariable("id") Long identification){
        return petService.SearchByClientId(identification);
    }*/
    
    @GetMapping("/add")
    public String showAddForms(Model model) {
        Pet pet = new Pet();
        //List<Client> clients = (List<Client>) clientService.SearchAll();
        model.addAttribute("mascota", pet);
        //model.addAttribute("clients", clients);
        return "createPet";
    }

    
    
    @PostMapping("/add")
    public ResponseEntity<Pet> agregarMascota(@RequestBody Pet pet) {
        System.out.println("\n\nMascota recibida: " + pet.getNombre());

        if (pet == null) {
            return ResponseEntity.badRequest().build(); // Retorna error si pet es null
        }

        // Si llegamos aquí, significa que pet no es null, así que puedes proceder a guardarla
        Pet savedPet = petService.add(pet); // Guarda la mascota en la base de datos
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPet); // Retorna el objeto guardado
    }

    @PutMapping("/{petId}/associate/{ownerId}")
    public ResponseEntity<Pet> associatePetWithOwner(@PathVariable Long petId, @PathVariable Long ownerId) {
        System.out.println("\n\nPet ID: " + petId);
        System.out.println("\n\nOwner ID: " + ownerId);

        Pet pet = petService.SearchById(petId);
        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Mascota no encontrada
        }

        Client owner = clientService.SearchById(ownerId);
        if (owner == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Cliente no encontrado
        }

        // Asociar el dueño a la mascota
        pet.setOwner(owner);
        petService.update(pet); // Asegúrate de que este método actualiza la mascota en la base de datos

        return ResponseEntity.ok(pet);
    }


    @GetMapping("/agendar")
    public String showAgendaForms(Model model) {
        Pet pet = new Pet(null, null, 0, null, null, null);
        model.addAttribute("mascota", pet);
        System.out.println("Peticion a agendar");
        return "agendarCita";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> borrarMascota(@PathVariable("id") Long id) {
        try {
            petService.DeleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve un 204 No Content si se elimina correctamente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Maneja cualquier error
        }
    }


    @PutMapping("/update/{id}")
    public Pet updatePet(@PathVariable("id") Long id, @RequestBody Pet pet) {
        
        System.out.println("\n\nRecibido para actualizar: " + pet.getNombre() + " id: " + pet.getId());
        
        // Verificar que exista antes de actualizar
        if (pet == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mascota no encontrada");
        }

        // Guarda la mascota actualizada
        petService.update(pet);

        // Devuelve la mascota actualizada
        return pet;
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalPets() {
        long totalPets = petService.getTotalPets();
        return ResponseEntity.ok(totalPets);
    }

}
