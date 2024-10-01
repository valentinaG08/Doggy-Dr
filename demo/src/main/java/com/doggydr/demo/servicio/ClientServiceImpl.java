package com.doggydr.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.repositorio.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepo;

    @Override
    public Client SearchById(Long id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public List<Client> SearchAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client SearchByUsername(String username) {
        return clientRepo.findByUsername(username);
    }

    @Override
    public Client SearchByDocument(Long document) {
        return clientRepo.findByDocument(document);
    }
    
    @Override
    public void Register(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void DeleteById(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public void update(Client client) {
        clientRepo.save(client);
    }

}