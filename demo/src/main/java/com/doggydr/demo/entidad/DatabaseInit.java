package com.doggydr.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.doggydr.demo.repositorio.ClientRepository;
import com.doggydr.demo.repositorio.PetRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Añadiendo los clientes al repositorio
        clientRepository.save(new Client("Juan Perez", "juanp", "password123", 1234567890L, "juanp@mail.com"));
        clientRepository.save(new Client("Maria Gomez", "mariag", "password456", 9876543210L, "mariag@mail.com"));
        clientRepository.save(new Client("Carlos Ruiz", "carlosr", "password789", 1122334455L, "carlosr@mail.com"));
    
        // Añadir mascotas
        petRepository.save( new Pet("Perry", "French Poodle", 2, "Baño", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", clientRepository.findById(1L).get()));
        petRepository.save( new Pet("Lucas", "Labrador", 2, "Baño", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", clientRepository.findById(2L).get()));
        petRepository.save( new Pet("Zeus", "Golden Retriever", 2, "Tratamiento", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg", clientRepository.findById(3L).get()));
        petRepository.save( new Pet("Luna", "Sibersian Husky", 3, "Vacunación", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg", clientRepository.findById(2L).get()));
        petRepository.save( new Pet("Bella", "Bulldog Francés", 1, "Chequeo General", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg", clientRepository.findById(3L).get()));
        petRepository.save( new Pet("Max", "Pastor Alemán", 4, "Desparasitación", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg", clientRepository.findById(1L).get()));
        
    }
    
}
