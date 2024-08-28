package com.doggydr.demo.servicio;

import java.util.Collection;

import com.doggydr.demo.entidad.Client;

public interface ClientService {
    public Client SearchById(Long id);

    public Collection<Client> SearchAll();

    public Client SearchByUsername(String username);

    public Client SearchByDocument(Long document);

    public void Register(Client client);
    
    public void DeleteById(Long id);

    public void update(Client client);
}
