package com.doggydr.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;
import com.doggydr.demo.servicio.VetService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost/4200")
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
    public List<Client> showClients(Model model){
        //model.addAttribute("clients", clientService.SearchAll());
        //return "admin_clients";
        return clientService.SearchAll();
    }

    @GetMapping("/pets")
    public List<Pet> showPets(Model model){
        //model.addAttribute("pets", petService.SearchAll());
        //return "admin_pets";
        return petService.SearchAll();
    }

    @GetMapping("/vets")
    public List<Vet> showVets(Model model){
       // model.addAttribute("vets", vetService.SearchAll());
        //return "admin_vets";
        return vetService.SearchAll();
    }

}
