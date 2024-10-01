package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Vet;

public interface VetService {

    public Vet SearchById(Long id);
    
    public List<Vet> SearchAll();

    public void DeleteById(Long id);
    
    public void update(Vet vet);

    public void add(Vet vet);
}
