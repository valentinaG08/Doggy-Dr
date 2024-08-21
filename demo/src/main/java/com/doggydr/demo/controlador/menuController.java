package com.doggydr.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class menuController {

    @GetMapping("/index")
    public String getInicio() {
        return "index";
    }

    @GetMapping("/servicios")
    public String getServicios() {
        return "servicios";
    }

    @GetMapping("/sedes")
    public String getSedes() {
        return "sedes";
    }

    @GetMapping("/blogs")
    public String getBlogs() {
        return "blogs";
    }

    @GetMapping("/contacto")
    public String getContacto() {
        return "contacto"; 
    }

    @GetMapping("/agendarCita")
    public String getAgendaCita() {
        return "redirect:/pet/add"; 
    }

}