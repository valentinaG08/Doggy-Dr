package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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

    /*@GetMapping("/client/{id}/pets")
    public List<Pet> showClientPets(@PathVariable("id") Long identification){
        return petService.SearchByClientId(identification);
    }*/
    
    @GetMapping("/add")
    public String showAddForms(Model model) {
        Pet pet = new Pet();
        List<Client> clients = (List<Client>) clientService.SearchAll();
        model.addAttribute("mascota", pet);
        model.addAttribute("clients", clients);
        return "createPet";
    }
    
    @PostMapping("/agregar")
    public void agregarMascota(@RequestBody Pet pet){
        /*System.out.println("Peticion");
        petService.add(pet);*/
        //return "redirect:/admin/pets";
        petService.add(pet);
    }

    @GetMapping("/agendar")
    public String showAgendaForms(Model model) {
        Pet pet = new Pet(null, null, 0, null, null, null);
        model.addAttribute("mascota", pet);
        System.out.println("Peticion a agendar");
        return "agendarCita";
    }

    @DeleteMapping("/delete/{id}")
    public void borrarMascota(@PathVariable("id") Long identification){
        petService.DeleteById(identification);
        //return "redirect:/admin/pets";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long identification, Model model) {
        Pet mascota = petService.SearchById(identification);
        List<Client> clients = (List<Client>) clientService.SearchAll();
        
        model.addAttribute("mascota", mascota);
        model.addAttribute("clients", clients);
        
        return "update_pet";
    }

    @PutMapping("/update/{id}")
    public void updatePet(@RequestBody Pet pet) {
        //pet.setId(identification); // Asegúrate de que el ID de la mascota se establece correctamente
        petService.update(pet);

        //return "redirect:/admin/pets";
    }
}
