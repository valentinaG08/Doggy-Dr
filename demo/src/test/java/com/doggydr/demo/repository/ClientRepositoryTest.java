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
public class ClientRepositoryTest {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClientRepository clientRepository;


    @BeforeEach
    void init() {

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
    public void ClientRepository_save_Client() {
        Client client = new Client("Luis Sanchez", "sanchez", 12345678910L, 3001234565L, "luissanchez@mail.com");

        Client savedClient = clientRepository.save(client);

        Assertions.assertThat(savedClient).isNotNull();
    }

    @Test
    public void ClientRepository_FindAll_NotEmpyList(){
        // arrange
        Client client1 = new Client("Luis Sanchez", "luiss3", 1234567896L, 3001234565L, "luis3@mail.com");
        Client client2 = new Client("Luis Sanchez", "luiss4", 1234567897L, 3001234565L, "luis4@mail.com");

        // act
        clientRepository.save(client1);
        clientRepository.save(client2);
        List<Client> clients = clientRepository.findAll();

        // assert
        Assertions.assertThat(clients).isNotNull();
        Assertions.assertThat(clients.size()).isEqualTo(7);
        Assertions.assertThat(clients.size()).isGreaterThan(0);
    }
}
