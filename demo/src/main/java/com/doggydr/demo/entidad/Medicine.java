package com.doggydr.demo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Medicine {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int availableUnits;
    private int soldUnits;
    private Double cost;
    private Double salesPrice;

    @ManyToMany(mappedBy = "medicines")
    private List<Treatment> treatments;

    
    public Medicine() {
    }

    public Medicine(String name, int availableUnits, int soldUnits, Double cost, Double salesPrice,
            List<Treatment> treatments) {
        this.name = name;
        this.availableUnits = availableUnits;
        this.soldUnits = soldUnits;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.treatments = treatments;
    }

    public Medicine(Long id, String name, int availableUnits, int soldUnits, Double cost, Double salesPrice,
            List<Treatment> treatments) {
        this.id = id;
        this.name = name;
        this.availableUnits = availableUnits;
        this.soldUnits = soldUnits;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.treatments = treatments;
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

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }
    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }
    public int getAvailableUnits() {
        return availableUnits;
    }
    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }
    public int getSoldUnits() {
        return soldUnits;
    }
    public void setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
    }
    
}
