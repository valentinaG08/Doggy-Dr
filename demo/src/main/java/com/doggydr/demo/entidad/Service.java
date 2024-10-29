package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Service() {
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    
}
