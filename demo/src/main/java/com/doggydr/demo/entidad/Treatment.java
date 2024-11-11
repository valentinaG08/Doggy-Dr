package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToMany;

@Entity
@Data @NoArgsConstructor
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
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @JsonIgnore
    //@ManyToMany(cascade = CascadeType.ALL) // Mantener ManyToMany
    //@JoinTable(
    //    name = "treatment_pet", // Nombre de la tabla intermedia
    //    joinColumns = @JoinColumn(name = "treatment_id"), // Referencia al tratamiento
    //    inverseJoinColumns = @JoinColumn(name = "pet_id") // Referencia a la mascota
    //)private List<Pet> pet = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private LocalDate startDate; // Fecha de inicio

    private LocalDate endDate; // Fecha de fin

    
    // Constructor con todos los campos
    public Treatment(String name, List<Medicine> medicines, String description, Vet vet, Pet pet) {
        this.name = name;
        this.medicines = medicines;
        this.description = description;
        this.vet = vet;
        this.pet = pet;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.of(2024, 12, 10);
    }

    public Treatment(Long id, String name, List<Medicine> medicines, String description, Vet vet, Pet pet) {
        this.id = id;
        this.name = name;
        this.medicines = medicines;
        this.description = description;
        this.vet = vet;
        this.pet = pet;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.of(2024, 12, 10);
    }

}
