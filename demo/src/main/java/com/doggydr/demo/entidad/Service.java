package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    public Service(String name, Double price) {
        this.name = name;
        this.price = price;
        //this.appointment = appointment;, Appointment appointment
    }

    public Service(Long id, String name, Double price, Appointment appointment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.appointment = appointment;
    }
    
}
