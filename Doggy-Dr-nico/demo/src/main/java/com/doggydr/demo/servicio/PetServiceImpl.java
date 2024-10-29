package com.doggydr.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.TreatmentRepository;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetRepository petRepo;

    @Autowired
    TreatmentRepository treatmentRepo;

    @Override
    public Pet SearchById(Long id) {
        return petRepo.findById(id).get();
    }


    @Override
    public List<Pet> SearchAll() {
        return petRepo.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        Optional<Pet> optionalPet = petRepo.findById(id);
        
        // Verificar si la mascota existe
        if (!optionalPet.isPresent()) {
            throw new ResourceClosedException("Pet not found with id: " + id);
        }

        Pet pet = optionalPet.get();

        // Desasociar la mascota de los tratamientos
        List<Treatment> treatments = treatmentRepo.findByPetsId(pet.getId());
        for (Treatment treatment : treatments) {
            treatment.setPet(null); // Desasocia la mascota
            treatmentRepo.save(treatment); // Guarda la modificación
        }

        // Ahora elimina la mascota
        petRepo.delete(pet);
    }


    @Override
    public void update(Pet pet) {
        petRepo.save(pet);
    }

    @Override
    public Pet add(Pet pet) {
        return petRepo.save(pet);
    }


    @Override
    public List<Pet> SearchByOwnerId(Long id) {
        return petRepo.findByOwnerId(id);
    }

    @Override
    public long getTotalPets() {
        //System.out.println("Mascotas: "+petRepo.count());
        return petRepo.count();
    }

    @Override
    public long findAllActives() {
        return petRepo.countByStatusTrue();
    }
    
}
