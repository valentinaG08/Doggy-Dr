package com.doggydr.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private Long document;

    private long phone;
    private String mail;

    public Vet(){
        
    }

    public Vet(String name, String userName, Long document, long phone, String mail) {
        this.name = name;
        this.userName = userName;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
    }

    public Vet(Long id, String name, String userName, Long document, long phone, String mail) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getDocument() {
        return document;
    }
    public void setDocument(Long document) {
        this.document = document;
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


    

}
