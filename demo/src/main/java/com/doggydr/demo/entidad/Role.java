package com.doggydr.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.Table;





@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;

    private String name;

    public Role(String name){
        this.name = name;
    }
}
