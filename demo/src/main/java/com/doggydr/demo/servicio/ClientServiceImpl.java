package com.doggydr.demo.servicio;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.repositorio.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepo;

    @Override
    public Client SearchById(int id) {
        return clientRepo.findById(id);
        // TODO Auto-generated method stub
    }

    @Override
    public Collection<Client> SearchAll() {
        return clientRepo.findAll();
        // TODO Auto-generated method stub
    }

    public Client SearchByUsername(String username) {
        return clientRepo.findByUsername(username);
    }
    
    public void Register(Client client) {
        clientRepo.save(client);
    }

    public void DeleteById(int id) {
        clientRepo.deleteById(id);
    }

    public void update(Client client) {
        clientRepo.update(client);
    }
}