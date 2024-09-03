package com.doggydr.demo.entidad;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "history_id", nullable = false)
    private History history;

    
    public Report() {
    }

    public Report(String description, Date date, History history) {
        this.description = description;
        this.date = date;
        this.history = history;
    }

    public Report(Long id, String description, Date date, History history) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    
}
