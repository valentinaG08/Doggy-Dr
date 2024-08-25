package com.doggydr.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String username;
    private String password;
    private long phone;
    private String mail;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();
    
    public Client(){

    }

    public Client(String name, String username, String password, long phone, String mail) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
    }

    public Client(Long id, String name, String username, String password, long phone, String mail, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    
}