package com.doggydr.demo.servicio;

import java.util.Collection;

import com.doggydr.demo.entidad.Client;

public interface ClientService {
    public Client SearchById(int id);

    public Collection<Client> SearchAll();
    
}
