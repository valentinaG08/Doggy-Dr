package com.doggydr.demo.servicio;

import java.util.Collection;

import com.doggydr.demo.entidad.Client;

public interface ClientService {
    public Client SearchById(int id);

    public Collection<Client> SearchAll();

    public Client SearchByUsername(String username);

    public void Register(Client client);
    
    public void DeleteById(int id);

    public void update(Client client);
}
