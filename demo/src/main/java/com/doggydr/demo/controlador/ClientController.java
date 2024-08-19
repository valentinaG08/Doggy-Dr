package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.servicio.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public String showClients(Model model){
        model.addAttribute("clients", clientService.SearchAll());
        return "show_all_clients";
    }

    @GetMapping("/{id}")
    public String showInfoClient(Model model, @PathVariable("id") int identification){
        model.addAttribute("client", clientService.SearchById(identification));
        return "client";
    }

    @GetMapping("/{id}/pets")
    public String showPetsByClient(@PathVariable int id, Model model) {
        Client client = clientService.SearchById(id);
        model.addAttribute("client", client);
        return "show_client_pets";
    }
}
