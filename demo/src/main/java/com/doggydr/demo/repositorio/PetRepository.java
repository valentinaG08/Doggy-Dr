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
        data.put(1, new Pet(1, "Perry", "French Poodle", 2, "Baño", "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg"));
        data.put(2, new Pet(2, "Lucas", "Labrador", 2, "Baño", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024"));
        data.put(3, new Pet(3, "Zeus", "Golden Retriever", 2, "Tratamiento", "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg"));
    }
    public Pet findById(int id){
        return data.get(id);
    }

    public Collection<Pet> findAll(){
        return data.values();
    }
}
