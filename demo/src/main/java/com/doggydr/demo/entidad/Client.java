package com.doggydr.demo.entidad;

import java.util.List;

public class Client{
    private Integer id;
    private String name;
    private String user;
    private String password;
    private long phone;
    private String mail;
    private List<Pet> pets;
    
    public Client(Integer id, String name, String user, String password, long phone, String mail, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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