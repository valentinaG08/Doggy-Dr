package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;

@RequestMapping("/pet")
@Controller
public class PetController {

    @Autowired
    PetService petService;
    
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public String showPets(Model model){
        model.addAttribute("mascotas", petService.SearchAll());
        return "show_all_pets";
    }

    @GetMapping("/find/{id}")
    public String showInfoPet(Model model, @PathVariable("id") Long identification){
        model.addAttribute("pet", petService.SearchById(identification));
        return "show_pet";
    }
    
    @GetMapping("/add")
    public String showAddForms(Model model) {
        Pet pet = new Pet();
        List<Client> clients = (List<Client>) clientService.SearchAll();
        model.addAttribute("mascota", pet);
        model.addAttribute("clients", clients);
        return "createPet";
    }
    
    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Pet pet){
        System.out.println("Peticion");
        petService.add(pet);
        System.out.println("hola, yo soy peso pluma"  + pet.getNombre());
        return "redirect:/admin/pets";
    }

    @GetMapping("/agendar")
    public String showAgendaForms(Model model) {
        Pet pet = new Pet(null, null, 0, null, null, null);
        model.addAttribute("mascota", pet);
        System.out.println("Peticion a agendar");
        return "agendarCita";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") Long identification){
        petService.DeleteById(identification);
        return "redirect:/admin/pets";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long identification, Model model) {
        Pet mascota = petService.SearchById(identification);
        List<Client> clients = (List<Client>) clientService.SearchAll();
        
        model.addAttribute("mascota", mascota);
        model.addAttribute("clients", clients);
        
        return "update_pet";
    }

    @PostMapping("/update/{id}")
    public String updatePet(@PathVariable("id") int identification, @ModelAttribute("mascota") Pet pet) {
        //pet.setId(identification); // Asegúrate de que el ID de la mascota se establece correctamente
        petService.update(pet);
        return "redirect:/admin/pets";
    }
}
