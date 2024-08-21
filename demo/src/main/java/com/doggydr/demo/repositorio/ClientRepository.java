package com.doggydr.demo.repositorio;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

@Repository
public class ClientRepository {

    private Map<Integer, Client> data = new HashMap<>();

    private int nextId = 1;

    public ClientRepository() {
        // Creando mascotas que serán asignadas a los clientes
        Pet perry = new Pet(1, "Perry", "French Poodle", 2, "Baño", 4.5,"https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg");
        Pet lucas = new Pet(2, "Lucas", "Labrador", 2, "Baño", 3.9, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024");
        Pet zeus = new Pet(3, "Zeus", "Golden Retriever", 2, "Tratamiento", 9.2, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg");
        Pet luna = new Pet(4, "Luna", "Siberian Husky", 3, "Vacunación", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg");
        Pet bella = new Pet(5, "Bella", "Bulldog Francés", 1, "Chequeo General", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg");
        Pet max = new Pet(6, "Max", "Pastor Alemán", 4, "Desparasitación", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg");
        
        // Creando listas de mascotas para cada cliente
        List<Pet> petsClient1 = new ArrayList<>();
        petsClient1.add(perry);
        petsClient1.add(luna);

        List<Pet> petsClient2 = new ArrayList<>();
        petsClient2.add(lucas);
        petsClient2.add(bella);
        petsClient2.add(max);

        List<Pet> petsClient3 = new ArrayList<>();
        petsClient3.add(zeus);

        // Añadiendo los clientes al repositorio
        data.put(1, new Client(nextId++, "Juan Perez", "juanp", "password123", 1234567890L, "juanp@mail.com", petsClient1));
        data.put(2, new Client(nextId++, "Maria Gomez", "mariag", "password456", 9876543210L, "mariag@mail.com", petsClient2));
        data.put(3, new Client(nextId++, "Carlos Ruiz", "carlosr", "password789", 1122334455L, "carlosr@mail.com", petsClient3));
    }

    // Método para encontrar un cliente por ID
    public Client findById(int id) {
        return data.get(id);
    }

    // Método para listar todos los clientes
    public Collection<Client> findAll() {
        return data.values();
    }

    public Client findByUsername(String username) {
        return data.values().stream()
                   .filter(c -> c.getUser().equals(username))
                   .findFirst()
                   .orElse(null);
    }

    public void save(Client client) {
        if (client.getId() == null) {
            client.setId(nextId++);
        }
        data.put(client.getId(), client);
    }
}
