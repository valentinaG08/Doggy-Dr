package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Vet;

public interface VetService {

    public Vet SearchById(Long id);
    
    public List<Vet> SearchAll();

    public void DeleteById(Long id);
    
    public Vet update(Vet vet);

    public Vet add(Vet vet);
}
