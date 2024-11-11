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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
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
    public Boolean status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")  // Specify the foreign key column
    public Client owner;
    
    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL) //@ManyToMany(mappedBy = "pet")
    private List<Treatment> treatments;

    //@JsonIgnore
    //@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Appointment> appointments = new ArrayList<>();

    
    public Pet(String nombre, String raza, int edad, String enfermedad, Double peso, String url,  Boolean status) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = url;
        this.status = status;
    }
    public Pet(String nombre, String raza, int edad, String enfermedad, Double peso, String url, Client owner,  Boolean status) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = url;
        this.owner = owner;
        this.status = status;
    }
    public Pet(Long id, String nombre, String raza, int edad, String enfermedad, Double peso, String urlImage,
            Client owner, List<Treatment> treatments, List<Appointment> appointments,  Boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.peso = peso;
        this.urlImage = urlImage;
        this.owner = owner;
        this.status = status;
        //this.treatments = treatments;
        //this.appointments = appointments;
    }
    
}
