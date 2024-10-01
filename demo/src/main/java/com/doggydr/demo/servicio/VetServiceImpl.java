package com.doggydr.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.VetRepository;

@Service
public class VetServiceImpl implements VetService{
    @Autowired
    VetRepository vetRepo;

    @Override
    public Vet SearchById(Long id) {
        return vetRepo.findById(id).get();
    }

    @Override
    public List<Vet> SearchAll() {
        return vetRepo.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        vetRepo.deleteById(id);
    }

    @Override
    public void update(Vet vet) {
        vetRepo.save(vet);
    }

    @Override
    public void add(Vet vet) {
        vetRepo.save(vet);
    }
}
