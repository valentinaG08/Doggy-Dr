package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class Medicine {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int availableUnits;
    private int soldUnits;
    private Double cost;
    private Double salesPrice;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicines", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();

//(Long id, String name, int availableUnits, int soldUnits, Double cost, Double salesPrice, List<Treatment> treatments)

}
