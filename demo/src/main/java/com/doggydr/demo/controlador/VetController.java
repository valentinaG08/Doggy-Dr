package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doggydr.demo.servicio.VetService;

@RequestMapping("/vet")
@Controller
public class VetController {
    
    @Autowired
    VetService vetService;

    @GetMapping("/delete/{id}")
    public String deleteVet(@PathVariable("id") Long identification){
        vetService.DeleteById(identification);
        return "redirect:/admin/vets";
    }

}
