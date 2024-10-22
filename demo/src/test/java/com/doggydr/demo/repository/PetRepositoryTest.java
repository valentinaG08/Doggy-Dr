package com.doggydr.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.repositorio.ClientRepository;
import com.doggydr.demo.repositorio.PetRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {

        // Owners
        clientRepository.save(new Client("Juan Perez", "juanp", 1234567891L, 3001234561L, "juanp@mail.com"));
        clientRepository.save(new Client("Maria Gomez", "mariag", 1234567892L, 3001234562L, "mariag@mail.com"));
        clientRepository.save(new Client("Carlos Ruiz", "carlosr", 1234567893L, 3001234563L, "carlosr@mail.com"));
        clientRepository.save(new Client("Ana Martinez", "anam", 1234567894L, 3001234564L, "anam@mail.com"));
        clientRepository.save(new Client("Luis Sanchez", "luiss", 1234567895L, 3001234565L, "luiss@mail.com"));
        
        // Pets
        petRepository.save(new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", clientRepository.findById(1L).get()));
        petRepository.save(new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", clientRepository.findById(2L).get()));
        petRepository.save(new Pet("Zeus", "Golden Retriever", 2, "Displasia de cadera", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg", clientRepository.findById(3L).get()));
        petRepository.save(new Pet("Luna", "Siberian Husky", 3, "Sarna", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg", clientRepository.findById(4L).get()));
        petRepository.save(new Pet("Bella", "Bulldog Francés", 1, "Alergias", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg", clientRepository.findById(5L).get()));
        petRepository.save(new Pet("Max", "Pastor Alemán", 4, "Dermatitis", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg", clientRepository.findById(1L).get()));
        petRepository.save(new Pet("Charlie", "Bulldog Francés", 2, "Problemas respiratorios", 12.8, "https://4.bp.blogspot.com/-atz5WgBqCys/VxasgrWNCEI/AAAAAAAB9Ao/ClzFWC9eEEcOWygTP4l3m0rEXVpRTX1ggCKgB/s1600/Perritos-cachorros-162.jpg", clientRepository.findById(2L).get()));
        
        
        
    }

    @Test
    public void PetRepository_save_Pet() {
        Pet pet = new Pet("Lucas", "Golden", 3, "Otitis", 10.3, "https://tse4.mm.bing.net/th?id=OIP.cxN-GoALtVN6Cq0D5aHZNgHaEo&pid=Api&P=0&h=180");

        Pet savedPet = petRepository.save(pet);

        Assertions.assertThat(savedPet).isNotNull();
    }

    @Test
    public void PetRepository_FindAll_NotEmpyList(){
        // arrange
        Pet pet1 = new Pet("Lucas", "Golden", 3, "Otitis", 10.3, "https://tse4.mm.bing.net/th?id=OIP.cxN-GoALtVN6Cq0D5aHZNgHaEo&pid=Api&P=0&h=180");
        Pet pet2 = new Pet("Paco", "Chiguagua", 2, "Otitis", 5.3, "https://st.depositphotos.com/1009420/1286/i/450/depositphotos_12868536-stock-photo-chihuahua.jpg");

        // act
        petRepository.save(pet1);
        petRepository.save(pet2);
        List<Pet> pets = petRepository.findAll();

        // assert
        Assertions.assertThat(pets).isNotNull();
        Assertions.assertThat(pets.size()).isEqualTo(9);
        Assertions.assertThat(pets.size()).isGreaterThan(0);
    }

    @Test
    public void PetRepository_findById_FindWrongIndex() {
        Long index = -1l;

        Optional<Pet> pet = petRepository.findById(index);

        Assertions.assertThat(pet).isEmpty();
    }

    @Test
    public void PetRepository_deleteById_EmptyPet(){
        Long index = 2l;

        petRepository.deleteById(index);

        Assertions.assertThat(petRepository.findById(index)).isEmpty();
    }

    @Test
    public void PetRepository_findById_Pet() {
        Long index = 1l;

        List<Pet> pets = petRepository.findByOwnerId(index);

        Assertions.assertThat(pets).isNotNull();
        Assertions.assertThat(pets.size()).isEqualTo(2);
        Assertions.assertThat(pets.size()).isGreaterThan(0);
    }

    @Test
    public void PetRepository_update_Pet() {

        String newName = "new name";

        Optional<Pet> pet = petRepository.findById(1l);
        Pet p = pet.get();
        p.setNombre(newName);
        Pet updated = petRepository.save(p);

        Assertions.assertThat(updated).isNotNull();
        Assertions.assertThat(updated.getNombre()).isEqualTo(newName);
    }
}
