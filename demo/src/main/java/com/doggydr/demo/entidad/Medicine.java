package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicine {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    
    public Medicine() {
    }

    public Medicine(String name, Double price, Treatment treatment) {
        this.name = name;
        this.price = price;
        this.treatment = treatment;
    }

    public Medicine(Long id, String name, Double price, Treatment treatment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.treatment = treatment;
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

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    
}
