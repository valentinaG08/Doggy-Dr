package com.doggydr.demo.repositorio;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import org.springframework.stereotype.Repository;
import com.doggydr.demo.entidad.Pet;

@Repository
public class PetRepository {
    private Map<Integer, Pet> data = new HashMap<>();
    public PetRepository(){
        data.put(1, new Pet("Perry", "French Poodle", 2, "Baño"));
        data.put(2, new Pet("Lucas", "Labrador", 2, "Baño"));
        data.put(3, new Pet("Zeus", "Golden Retriever", 2, "Tratamiento"));
    }
    public Pet findById(int id){
        return data.get(id);
    }

    public Collection<Pet> findAll(){
        return data.values();
    }
}
