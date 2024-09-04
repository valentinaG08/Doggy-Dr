package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String raza;
    private int edad;
    private String enfermedad;
    private Double peso;
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "owner_id")  // Specify the foreign key column
    private Client owner;
    
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    
    public Pet() {

    }
    public Pet(String nombre, String raza, int edad, String enfermedad, Double peso, String url) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = url;
    }
    public Pet(String nombre, String raza, int edad, String enfermedad, Double peso, String url, Client owner) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = url;
        this.owner = owner;
    }
    public Pet(Long id, String nombre, String raza, int edad, String enfermedad, Double peso, String urlImage,
            Client owner, List<Treatment> treatments, List<Appointment> appointments) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = urlImage;
        this.owner = owner;
        this.treatments = treatments;
        this.appointments = appointments;
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
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
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
    public List<Treatment> getTreatments() {
        return treatments;
    }
    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
}
