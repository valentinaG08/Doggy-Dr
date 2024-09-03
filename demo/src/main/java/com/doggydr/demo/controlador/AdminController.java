package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;
import com.doggydr.demo.servicio.VetService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ClientService clientService;

    @Autowired
    PetService petService;

    @Autowired
    VetService vetService;

    @GetMapping("")
    public String showFront(Model model){
        return "admin_front";
    }

    @GetMapping("/clients")
    public String showClients(Model model){
        model.addAttribute("clients", clientService.SearchAll());
        return "admin_clients";
    }

    @GetMapping("/pets")
    public String showPets(Model model){
        model.addAttribute("pets", petService.SearchAll());
        return "admin_pets";
    }

    @GetMapping("/vets")
    public String showVets(Model model){
        model.addAttribute("vets", vetService.SearchAll());
        return "admin_vets";
    }

}
