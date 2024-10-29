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


@Entity
public class Client{

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
   
    public Client(){

    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", username=" + username + ", document=" + document + ", phone="
                + phone + ", mail=" + mail + ", pets=" + pets + "]";
    }

    
}