package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long id;

    private Double price;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;


    
    public Payment() {
    }

    public Payment(Double price, Appointment appointment) {
        this.price = price;
        this.appointment = appointment;
    }

    public Payment(Long id, Double price, Appointment appointment) {
        this.id = id;
        this.price = price;
        this.appointment = appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
