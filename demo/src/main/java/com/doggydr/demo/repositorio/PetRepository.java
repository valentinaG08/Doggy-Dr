package com.doggydr.demo.repositorio;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import org.springframework.stereotype.Repository;
import com.doggydr.demo.entidad.Pet;

@Repository
public class PetRepository {
    private Map<Integer, Pet> dataPet = new HashMap<>();
    public PetRepository(){
        dataPet.put(1, new Pet(1, "Perry", "French Poodle", 2, "Baño", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg"));
        dataPet.put(2, new Pet(2, "Lucas", "Labrador", 2, "Baño", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024"));
        dataPet.put(3, new Pet(3, "Zeus", "Golden Retriever", 2, "Tratamiento", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg"));
        dataPet.put(4, new Pet(4, "Luna", "Siberian Husky", 3, "Vacunación", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg"));
        dataPet.put(5, new Pet(5, "Bella", "Bulldog Francés", 1, "Chequeo General", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg"));
        dataPet.put(6, new Pet(6, "Max", "Pastor Alemán", 4, "Desparasitación", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg"));
        
    }
    public Pet findById(int id){
        return dataPet.get(id);
    }

    public Collection<Pet> findAll(){
        return dataPet.values();
    }

    public void deleteById(int id){
        dataPet.remove(id);
    }

    public void update(Pet pet){
        dataPet.put(pet.getId(), pet);
    }
    
    public void add(Pet pet){
        int tam = dataPet.size();
        /*int lastId = data.get(tam).getId();
        pet.setId(lastId+1);*/
        System.out.println("hola, yo soy peso pluma con tam: " + tam);
        dataPet.put(pet.getId(), pet);
    }
}
