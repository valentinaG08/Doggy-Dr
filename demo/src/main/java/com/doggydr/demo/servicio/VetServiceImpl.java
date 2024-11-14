package com.doggydr.demo.servicio;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.hibernate.ResourceClosedException;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doggydr.demo.entidad.Admin;
import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.RoleRepository;
import com.doggydr.demo.repositorio.UserRepository;
import com.doggydr.demo.repositorio.VetRepository;

import io.micrometer.observation.annotation.Observed;

@Service
public class VetServiceImpl implements VetService {
    @Autowired
    VetRepository vetRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Vet SearchById(Long id) {
        return vetRepo.findById(id).get();
    }

    @Override
    public List<Vet> SearchAll() {
        return vetRepo.findAll();
    }

    @Transactional
    @Override
    public void DeleteById(Long id) {
        // Buscar el vet por su ID
        Optional<Vet> optionalVet = vetRepo.findById(id);

        if (!optionalVet.isPresent()) {
            throw new ResourceClosedException("Vet not found with id: " + id);
        }

        System.out.println("\nUser ID passed: " + id);

        // Obtener el Vet
        Vet vet = optionalVet.get();

        List<Object[]> user1 = userRepo.getRolesByUserId(vet.getId());
        System.out.println("\nSize of user1: " + user1.size());
        if (user1 != null) {
            for (Object[] objects : user1) {
                System.out.println("Role ID: " + objects[0] + ", User ID: " + objects[1]);
            }
        }

        // Borrar el rol
        userRepo.removeRolesByUserId(vet.getId());

        user1 = userRepo.getRolesByUserId(id);
        System.out.println("\nSize of user2: " + user1.size());

        if (user1 != null) {
            for (Object[] objects : user1) {
                System.out.println("user 2:" + objects);
            }
        }

        vetRepo.deleteById(id);
    }

    @Override
    public Vet update(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public Vet add(Vet vet) {
        return vetRepo.save(vet);
    }

    @Override
    public Vet SearchByDocument(Long document) {
        return vetRepo.findByDocument(document);
    }

    @Override
    public Vet findByUserName(String username) {
        return vetRepo.findByUserName(username);
    }

    @Override
    public Vet findByPassword(String password) {
        return vetRepo.findByPassword(password);
    }

    @Override
    public List<Treatment> findTreatmentsByVetId(Long vetId) {
        Vet vet = SearchById(vetId);
        return vet != null ? vet.getTreatments() : null;
    }

    @Override
    public List<Pet> findPetsByVetId(Long vetId) {
        List<Treatment> treatments = findTreatmentsByVetId(vetId);
        List<Pet> pets = new ArrayList<>();
        for (Treatment treatment : treatments) {
            pets.add(treatment.getPet());
        }
        return pets;
    }

    @Override
    public long findAllActives() {
        return vetRepo.countByStatusTrue();
    }

    @Override
    public long findAllInactives() {
        return vetRepo.countByStatusFalse();
    }
}
