package com.doggydr.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.servicio.VetService;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/vet")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {
    
    @Autowired
    VetService vetService;

    @GetMapping("/all")
    public List<Vet> showVets(Model model) {
        return vetService.SearchAll();
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteVet(@PathVariable("id") Long identification){
        vetService.DeleteById(identification);
        //return "redirect:/admin/vets";
    }

    @GetMapping("/add")
    public String register(Model model){
        return "clientRegister";
    }

    @PostMapping("/add")
    public void register(@RequestBody Vet newVet) {
        
        System.out.println("\n\nVeterinario recibido: " + newVet.getName());

        vetService.add(newVet);

    }
}
