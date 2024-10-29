package com.doggydr.demo.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment_pet")
public class TreatmentPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    public TreatmentPet() {
        // Constructor por defecto
    }

    // Constructor con todos los campos
    public TreatmentPet(Treatment treatment, Pet pet) {
        this.treatment = treatment;
        this.pet = pet;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
