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
public class Vet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String specialty;
    private String urlImage;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private Long document;

    private long phone;
    private String mail;

    @JsonIgnore
    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treatment> treatments = new ArrayList<>();

    
    public Vet(){
        
    }
    
    public Vet(String name, String specialty, String urlImage, String userName, Long document, long phone, String mail) {
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
    }

    public Vet(String name, String specialty, String urlImage, String userName, Long document, long phone, String mail,
            List<Treatment> treatments) {
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
        this.treatments = treatments;
    }
    public Vet(Long id, String name, String specialty, String urlImage, String userName, Long document, long phone,
            String mail, List<Treatment> treatments) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
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
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

}
