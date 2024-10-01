package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.servicio.VetService;

@RequestMapping("/vet")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {
    
    @Autowired
    VetService vetService;

    @DeleteMapping("/delete/{id}")
    public void deleteVet(@PathVariable("id") Long identification){
        vetService.DeleteById(identification);
        //return "redirect:/admin/vets";
    }

}
