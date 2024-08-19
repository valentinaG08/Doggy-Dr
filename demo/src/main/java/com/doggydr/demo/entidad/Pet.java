package com.doggydr.demo.entidad;

public class Pet {
    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private String servicio;
    private Double peso;
    private String urlImage;
    
    public Pet(int id, String nombre, String raza, int edad, String servicio, Double peso, String url) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.servicio = servicio;
        this.peso = peso;
        this.urlImage = url;
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
    public void serUrlImage(String url) {
        this.urlImage = url;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    
}
