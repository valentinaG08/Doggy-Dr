package com.doggydr.demo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.DTOs.ClientDTO;
import com.doggydr.demo.DTOs.ClientMapper;
import com.doggydr.demo.DTOs.VetDTO;
import com.doggydr.demo.DTOs.VetMapper;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.UserEntity;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.UserRepository;
import com.doggydr.demo.security.CustomUserDetailService;
import com.doggydr.demo.servicio.ClientService;
import com.doggydr.demo.servicio.PetService;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    PetService petService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @GetMapping("/all")
    public List<Client> showClients(Model model) {
        // model.addAttribute("clients", clientService.SearchAll());
        // return "show_all_clients";
        return clientService.SearchAll();
    }

    @GetMapping("/{id}")
    public Client showInfoClient(@PathVariable("id") Long identification) {
        // model.addAttribute("client", clientService.SearchById(identification));
        // return "client";
        return clientService.SearchById(identification);
    }

    @GetMapping("/document/{id}")
    public Client showInfoClientByDocument(@PathVariable("id") Long identification) {
        // model.addAttribute("client", clientService.SearchById(identification));
        // return "client";
        return clientService.SearchByDocument(identification);
    }

    @GetMapping("/{id}/pets")
    public List<Pet> showPetsByClient(@PathVariable("id") Long id) {
        Client client = clientService.SearchById(id);
        System.out.println("\n\n Pets: " + client.getPets().size());

        return client.getPets();
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "clientRegister";
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Client client) {
       
        /*System.out.println("\n\nCliente recibido: " + newClient.getName());

        Client savedClient = clientService.Register(newClient);
        ClientDTO clientDTO = ClientMapper.INSTANCE.convert(savedClient);

        return ResponseEntity.ok(clientDTO); */

        if(userRepository.existsByUsername(client.getMail())){
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity =  customUserDetailService.ClienteToUser(client);
        client.setUser(userEntity);
        Client clientDB = clientService.Register(client);
        ClientDTO newClientDTO = ClientMapper.INSTANCE.convert(clientDB);
        if(newClientDTO == null){
            return new ResponseEntity<ClientDTO>(newClientDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ClientDTO>(newClientDTO,HttpStatus.CREATED);

        
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public void borrarUsuario(@PathVariable("id") Long identification) {
        clientService.DeleteById(identification);
        // return "redirect:/admin/clients";
    }

    @GetMapping("/update/{id}")
    public String formularioActualizarUsuario(@PathVariable("id") Long id, Model model) {

        model.addAttribute("Client", clientService.SearchById(id));
        return "update_client";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> actualizarUsuario(@PathVariable("id") Long id, @RequestBody Client cliente) {

        if (cliente == null || !cliente.getId().equals(id)) {
            System.out.println("\n\nCliente recibido: " + cliente.getId());
            return ResponseEntity.badRequest().build(); // Retorna un error si el ID no coincide
        }

        List<Pet> pets = petService.SearchByOwnerId(id);

        cliente.setPets(pets);

        Client updatedClient = clientService.update(cliente);
        return ResponseEntity.ok(updatedClient);
    }

}
