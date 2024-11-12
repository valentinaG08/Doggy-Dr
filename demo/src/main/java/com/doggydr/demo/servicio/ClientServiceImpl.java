package com.doggydr.demo.servicio;

import java.util.List;
import java.util.Optional;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.repositorio.ClientRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.UserRepository;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepo;

    @Autowired
    PetService petService;

    @Autowired
    UserRepository userRepo;

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
    public Client Register(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void DeleteById(Long id) {
        // Buscar el owner por su ID
        Optional<Client> optionalOwner = clientRepo.findById(id);
        userRepo.deleteById(id);
        if (!optionalOwner.isPresent()) {
            throw new ResourceClosedException("Owner not found with id: " + id);
        }

        // Obtener el owner
        Client owner = optionalOwner.get();

        // Obtener y eliminar todas las mascotas asociadas
        List<Pet> pets = petService.SearchByOwnerId(owner.getId());
        for (Pet pet : pets) {
            petService.DeleteById(pet.getId()); // Eliminar cada mascota
        }

        // Ahora eliminar el owner
        clientRepo.delete(owner);
    }

    @Override
    public Client update(Client client) {
        return clientRepo.save(client);
    }

}