package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doggydr.demo.servicio.PetService;

@RequestMapping("/pet")
@Controller
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/all")
    public String showPets(Model model){
        model.addAttribute("pets", petService.SearchAll());
        return "show_all_pets";
    }

    @GetMapping("/find/{id}")
    public String showInfoPet(Model model, @PathVariable("id") int identification){
        model.addAttribute("pet", petService.SearchById(identification));
        return "show_pet";
    }
    
}
