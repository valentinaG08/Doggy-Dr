package com.doggydr.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.LoginRequest;
import com.doggydr.demo.servicio.ClientService;

import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.servicio.VetService;
import com.doggydr.demo.DTOs.AdminDTO;
import com.doggydr.demo.DTOs.AdminMapper;
import com.doggydr.demo.DTOs.VetDTO;
import com.doggydr.demo.DTOs.VetMapper;
import com.doggydr.demo.entidad.Admin;
import com.doggydr.demo.servicio.AdminService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    ClientService clientService;

    @Autowired
    VetService vetService;

    @Autowired
    AdminService adminService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/client")
    public String login(Model model) {
        return "clientLogin";
    }

    @PostMapping("/client")
    public ResponseEntity login(@RequestBody Long document) {
        /*
         * System.out.println("\n\n\nDocumento:"+ document);
         * 
         * // Buscar cliente en la base de datos por su documento
         * Client client = clientService.SearchByDocument(document);
         * 
         * // Si el cliente se encuentra, devolver información del cliente en JSON
         * if (client != null) {
         * return ResponseEntity.ok(client);
         * } else {
         * // Si no se encuentra, devolver un error con un código de estado 404
         * return
         * ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
         * }
         * 
         */
        System.out.println("\n\n\nDocumento:"+ document);
        Client client = clientService.SearchByDocument(document);
         Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(client.getMail(), "123")
         );

         SecurityContextHolder.getContext().setAuthentication(authentication);

         return new ResponseEntity<String>("Usuario ingresado con exito", HttpStatus.OK);
    }

    @GetMapping("/vet")
    public String vetlogin(Model model) {
        return "vetLogin";
    }

    @PostMapping("/vet")
    public ResponseEntity vetLogin(@RequestBody LoginRequest loginRequest) {
        Vet vet = vetService.findByUserName(loginRequest.getUsername());
        /*
         if (vet != null && vet.getPassword().equals(loginRequest.getPassword())) {
            VetDTO vetDTO = VetMapper.INSTANCE.convert(vet);
            return ResponseEntity.ok(vetDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Veterinario no encontrado o contraseña incorrecta");
        }
         */

         Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(vet.getMail(), vet.getPassword())
         );

         SecurityContextHolder.getContext().setAuthentication(authentication);

         return new ResponseEntity<String>("Usuario ingresado con exito", HttpStatus.OK);
    }
        

    @GetMapping("/admin")
    public String adminlogin(Model model) {
        return "adminLogin";
    }

    @PostMapping("/admin")
    public ResponseEntity<?> adminLogin(@RequestBody LoginRequest loginRequest) {
        Admin admin = adminService.findByUsername(loginRequest.getUsername());

        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            AdminDTO adminDTO = AdminMapper.INSTANCE.convert(admin);
            return ResponseEntity.ok(adminDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin no encontrado o contraseña incorrecta");
        }
    }
}

