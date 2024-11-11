package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Client{

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity user;
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private Long document;

    private long phone;
    private String mail;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();
   
    public Client(String name, String username, Long document, Long phone, String mail) {
        this.name = name;
        this.username = username;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
    }

    public Client(Long id, String name, String username, Long document, Long phone, String mail, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", username=" + username + ", document=" + document + ", phone="
                + phone + ", mail=" + mail + ", pets=" + pets + "]";
    }

}