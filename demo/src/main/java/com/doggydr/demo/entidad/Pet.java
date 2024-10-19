package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    public Long id;

    public String nombre;
    public String raza;
    public int edad;
    public String enfermedad;
    public Double peso;
    public String urlImage;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")  // Specify the foreign key column
    public Client owner;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "pets")
    private List<Treatment> treatments;

    //@JsonIgnore
    //@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Appointment> appointments = new ArrayList<>();

    
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
        //this.treatments = treatments;
        //this.appointments = appointments;
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
    /*public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }*/
    
}
