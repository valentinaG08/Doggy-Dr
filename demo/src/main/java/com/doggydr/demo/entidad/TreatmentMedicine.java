package com.doggydr.demo.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treatment_medicine")
@Data @NoArgsConstructor
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

    // Constructor con todos los campos
    public TreatmentMedicine(Treatment treatment, Medicine pet) {
        this.treatment = treatment;
        this.pet = pet;
    }
}
