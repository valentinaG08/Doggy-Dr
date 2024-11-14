package com.doggydr.demo.servicio;

import java.util.List;
import java.util.Optional;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.UserEntity;
import com.doggydr.demo.repositorio.ClientRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepo;

    @Autowired
    PetService petService;

    @Autowired
    UserRepository userRepo;

    @PersistenceContext
    private EntityManager entityManager;

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
    @Transactional
    public void DeleteById(Long id) {
        // Buscar el owner por su ID
        Optional<Client> optionalOwner = clientRepo.findById(id);

        if (!optionalOwner.isPresent()) {
            throw new ResourceClosedException("Owner not found with id: " + id);
        }

        // Obtener el owner
        Client owner = optionalOwner.get();

        System.out.println("\nUser ID passed: " + id);

        // Borrar el rol
        List<Object[]> user1 = userRepo.getRolesByUserId(id);
        System.out.println("\nSize of user1: " + user1.size());
        if (user1 != null) {
            for (Object[] objects : user1) {
                System.out.println("Role ID: " + objects[0] + ", User ID: " + objects[1]);
            }
        }
        userRepo.removeRolesByUserId(owner.getId());

        user1 = userRepo.getRolesByUserId(id);
        System.out.println("\nSize of user2: " + user1.size());

        if (user1 != null) {
            for (Object[] objects : user1) {
                System.out.println("user 2:" + objects);
            }
        }

        // Obtener y eliminar todas las mascotas asociadas
        List<Pet> pets = petService.SearchByOwnerId(owner.getId());
        for (Pet pet : pets) {
            petService.DeleteById(pet.getId()); // Eliminar cada mascota
        }

        // Eliminar el owner
        clientRepo.delete(owner);
        clientRepo.flush(); // Forzar que Hibernate sincronice la sesión con la base de datos

        Optional<Client> cliente = clientRepo.findById(id);
        if (cliente.isPresent()) {
            System.out.println("client no borro:" + cliente.get().getId());
        } else {
            System.out.println("client SI borro:");
        }

    }

    @Override
    public Client update(Client client) {
        return clientRepo.save(client);
    }

}