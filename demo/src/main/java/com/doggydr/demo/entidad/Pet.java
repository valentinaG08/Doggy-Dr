package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String raza;
    private int edad;
    private String servicio;
    private Double peso;
    private String urlImage;

    @ManyToOne
    private Client owner;
    
    public Pet() {

    }
    public Pet(String nombre, String raza, int edad, String servicio, Double peso, String url) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.servicio = servicio;
        this.peso = peso;
        this.urlImage = url;
    }
    public Pet(String nombre, String raza, int edad, String servicio, Double peso, String url, Client owner) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.servicio = servicio;
        this.peso = peso;
        this.urlImage = url;
        this.owner = owner;
    }
    public Pet(Long id, String nombre, String raza, int edad, String servicio, Double peso, String url, Client owner) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.servicio = servicio;
        this.peso = peso;
        this.urlImage = url;
        this.owner = owner;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getServicio() {
        return servicio;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public void setUrlImage(String url) {
        this.urlImage = url;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Client getOwner() {
        return owner;
    }
    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
}
