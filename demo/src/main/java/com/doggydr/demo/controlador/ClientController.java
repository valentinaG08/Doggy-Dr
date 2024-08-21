package com.doggydr.demo.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/login")
    public String login(Model model){
        return "clientLogin";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, Model model) {
        Client client = clientService.SearchByUsername(username);
        if (client != null) {
            model.addAttribute("client", client);
            return "client";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "clientLogin";
        }
    }


    @GetMapping("/register")
    public String register(Model model){
        return "clientRegister";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String name,
                           @RequestParam String email, @RequestParam String phone, Model model) {
        if (clientService.SearchByUsername(username) != null) {
            model.addAttribute("error", "El nombre de usuario ya está en uso");
            return "clientRegister";
        }

        Client newClient = new Client(null, name, username, null, Long.parseLong(phone), email, new ArrayList<>());
        clientService.Register(newClient);

        model.addAttribute("client", newClient);
        return "client"; 
    }

    @GetMapping("/logout")
    public String logout(Model model){
        return "index";
    }
}
