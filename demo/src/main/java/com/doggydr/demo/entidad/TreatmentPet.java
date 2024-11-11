package com.doggydr.demo.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treatment_pet")
@Data @NoArgsConstructor
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

    // Constructor con todos los campos
    public TreatmentPet(Treatment treatment, Pet pet) {
        this.treatment = treatment;
        this.pet = pet;
    }

}
