package com.doggydr.demo.entidad;

public class Pet {
    private String nombre;
    private String raza;
    private int edad;
    private String servicio;
    public Pet(String nombre, String raza, int edad, String servicio) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.servicio = servicio;
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

    
}
