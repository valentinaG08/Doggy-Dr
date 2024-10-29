package com.doggydr.demo.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment_medicine")
public class TreatmentMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine pet;

    public TreatmentMedicine() {
        // Constructor por defecto
    }

    // Constructor con todos los campos
    public TreatmentMedicine(Treatment treatment, Medicine pet) {
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

    public Medicine getPet() {
        return pet;
    }

    public void setPet(Medicine pet) {
        this.pet = pet;
    }
}
