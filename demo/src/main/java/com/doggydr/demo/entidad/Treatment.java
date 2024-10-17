package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

@Entity
public class Treatment {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "treatment_medicine",
        joinColumns = @JoinColumn(name = "treatment_id"),
        inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private List<Medicine> medicines = new ArrayList<>();

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL) // Mantener ManyToMany
    @JoinTable(
        name = "treatment_pet", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "treatment_id"), // Referencia al tratamiento
        inverseJoinColumns = @JoinColumn(name = "pet_id") // Referencia a la mascota
    )
    private List<Pet> pets = new ArrayList<>();

    public Treatment(){

    }
    
    // Constructor con todos los campos
    public Treatment(String name, List<Medicine> medicines, String description, Vet vet, List<Pet> pets) {
        this.name = name;
        this.medicines = medicines;
        this.description = description;
        this.vet = vet;
        this.pets = pets;
    }

    public Treatment(Long id, String name, List<Medicine> medicines, String description, Vet vet, List<Pet> pet) {
        this.id = id;
        this.name = name;
        this.medicines = medicines;
        this.description = description;
        this.vet = vet;
        this.pets = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pet) {
        this.pets = pet;
    }
    
}
