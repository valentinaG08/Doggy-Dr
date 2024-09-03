package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class History {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")  // Specifies the foreign key column
    private Pet pet;

    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports = new ArrayList<>();

    public History(){
        
    }

    public History(Pet pet, List<Report> reports) {
        this.pet = pet;
        this.reports = reports;
    }

    public History(Long id, Pet pet, List<Report> reports) {
        this.id = id;
        this.pet = pet;
        this.reports = reports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    
    
}
