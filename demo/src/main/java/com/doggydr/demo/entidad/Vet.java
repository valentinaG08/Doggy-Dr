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
@Data @NoArgsConstructor
public class Vet {

    @OneToOne(cascade = CascadeType.REMOVE)
    private UserEntity user;
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String specialty;
    private String urlImage;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private Long document;

    private long phone;
    private String mail;
    private Boolean status;

    //@JsonIgnore
    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treatment> treatments = new ArrayList<>();


    public Vet(String name, String specialty, String urlImage, String userName, Long document, long phone, String mail, String password, Boolean status) {
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.document = document;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
    }

    public Vet(String name, String specialty, String urlImage,String userName, Long document, long phone, String mail,
            List<Treatment> treatments, String password, Boolean status) {
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.document = document;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.treatments = treatments;
    }
    public Vet(Long id, String name, String specialty, String urlImage,String password, String userName, Long document, long phone,
            String mail, List<Treatment> treatments, Boolean status) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.urlImage = urlImage;
        this.userName = userName;
        this.password = password;
        this.document = document;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.treatments = treatments;
    }
}
