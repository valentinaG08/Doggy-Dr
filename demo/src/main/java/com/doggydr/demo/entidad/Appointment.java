package com.doggydr.demo.entidad;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private Time time;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @JsonIgnore
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> services = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true) 
    private Payment payment;

    
    public Appointment() {
    }

    public Appointment(Date date, Time time, Pet pet, List<Service> services, Payment payment) {
        this.date = date;
        this.time = time;
        this.pet = pet;
        this.services = services;
        this.payment = payment;
    }

    public Appointment(Long id, Date date, Time time, Pet pet, List<Service> services, Payment payment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.pet = pet;
        this.services = services;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    
}
