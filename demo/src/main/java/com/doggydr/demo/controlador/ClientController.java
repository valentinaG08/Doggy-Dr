package com.doggydr.demo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.servicio.ClientService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> showClients(Model model){
        //model.addAttribute("clients", clientService.SearchAll());
        //return "show_all_clients";
        return clientService.SearchAll();
    }

    @GetMapping("/{id}")
    public Client showInfoClient(@PathVariable("id") Long identification){
        //model.addAttribute("client", clientService.SearchById(identification));
       // return "client";
       return clientService.SearchById(identification);
    }
    //Aqui
    @GetMapping("/{id}/pets")
    public Client showPetsByClient(@PathVariable("id") Long id) {
        Client client = clientService.SearchById(id);
        /*model.addAttribute("client", client);
        return "show_client_pets";*/
        return client;
    }   

    @GetMapping("/register")
    public String register(Model model){
        return "clientRegister";
    }

    //Falta validación de usuario ya existente
    @PostMapping("/register")
    public void register(@RequestBody Client newClient) {
        /*if (clientService.SearchByUsername(username) != null) {
            model.addAttribute("error", "El nombre de usuario ya está en uso");
            //return "clientRegister";
        }*/

        //Client newClient = new Client(name, username, null, Long.parseLong(phone), email);
        clientService.Register(newClient);

        //model.addAttribute("client", newClient);
        //return "client"; 
    }

    @GetMapping("/logout")
    public String logout(Model model){
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public void borrarUsuario(@PathVariable("id") Long identification){
        clientService.DeleteById(identification);
        //return "redirect:/admin/clients";
    }   

    @GetMapping("/update/{id}")
    public String formularioActualizarUsuario(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clientService.SearchById(id));
        return "update_client";
    }

    @PutMapping("/update/{id}")
    public void actualizarUsuario(@RequestBody Client cliente) {
        //Client clienteExistente = clientService.SearchById(id);
    
        /*if (clienteExistente.getPets() == null) {
            clienteExistente.setPets(new ArrayList<>());
        }
        
        cliente.setPets(clienteExistente.getPets());
    
        cliente.setId(id);
        clientService.update(cliente);
    
        return "redirect:/admin/clients";*/
        clientService.update(cliente);
    }
}
    

