package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.servicio.ClientService;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public String login(Model model){
        return "clientLogin";
    }

    @PostMapping("/client")
    public String login(@RequestParam Long document, Model model) {
        Client client = clientService.SearchByDocument(document);
        if (client != null) {
            model.addAttribute("client", client);
            return "redirect:/client/" + client.getId() + "/pets";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "clientLogin";
        }
    }


}
