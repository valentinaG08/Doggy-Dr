package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Client;

public interface ClientService {
    public Client SearchById(Long id);

    public List<Client> SearchAll();

    public Client SearchByUsername(String username);

    public Client SearchByDocument(Long document);

    public void Register(Client client);
    
    public void DeleteById(Long id);

    public Client update(Client client);
}
