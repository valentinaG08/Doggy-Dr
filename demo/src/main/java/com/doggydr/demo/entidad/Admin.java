package com.doggydr.demo.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Admin {
    
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String username;

    private String password;

}
