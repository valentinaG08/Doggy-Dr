package com.doggydr.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;

    private Double price;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;


    public Payment(Double price, Appointment appointment) {
        this.price = price;
        this.appointment = appointment;
    }

    public Payment(Long id, Double price, Appointment appointment) {
        this.id = id;
        this.price = price;
        this.appointment = appointment;
    }

}
