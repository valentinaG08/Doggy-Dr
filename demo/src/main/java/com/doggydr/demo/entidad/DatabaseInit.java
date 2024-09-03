package com.doggydr.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.doggydr.demo.repositorio.AdminRepository;
import com.doggydr.demo.repositorio.ClientRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.ServiceRepository;
import com.doggydr.demo.repositorio.VetRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    VetRepository vetRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Añadiendo los clientes al repositorio
        createClients();

        // Añadir mascotas
        createPets();

        // Añadir administradores
        adminRepository.save(new Admin("Juan Sebastian", "juanSe", "angarita"));

        // Añadir servicios
        serviceRepository.save(new Service("Consultas y chequeos generales", 20.500));
        serviceRepository.save(new Service("Vacunaciones y Desparasitación", 50.500));
        serviceRepository.save(new Service("Odontología veterinaria", 120.500));
        serviceRepository.save(new Service("Laboratorio y diagnóstico por Imágenes", 80.500));

        // Añadir veterinarios
        vetRepository.save(new Vet("Daniel Carvajal", "daniC", 10131415L, 310123123, "daniel@gmail.com"));
        vetRepository.save(new Vet("Valentina Garcia", "valeG", 20212223L, 310321321, "valentina@gmail.com"));

    }

    public void createClients () {
        clientRepository.save(new Client("Juan Perez", "juanp", 1234567891L, 3001234561L, "juanp@mail.com"));
        clientRepository.save(new Client("Maria Gomez", "mariag", 1234567892L, 3001234562L, "mariag@mail.com"));
        clientRepository.save(new Client("Carlos Ruiz", "carlosr", 1234567893L, 3001234563L, "carlosr@mail.com"));
        clientRepository.save(new Client("Ana Martinez", "anam", 1234567894L, 3001234564L, "anam@mail.com"));
        clientRepository.save(new Client("Luis Sanchez", "luiss", 1234567895L, 3001234565L, "luiss@mail.com"));
        clientRepository.save(new Client("Laura Diaz", "laurad", 1234567896L, 3001234566L, "laurad@mail.com"));
        clientRepository.save(new Client("Miguel Torres", "miguelt", 1234567897L, 3001234567L, "miguelt@mail.com"));
        clientRepository.save(new Client("Carla Ramirez", "carlar", 1234567898L, 3001234568L, "carlar@mail.com"));
        clientRepository.save(new Client("Jose Hernandez", "joseh", 1234567899L, 3001234569L, "joseh@mail.com"));
        clientRepository.save(new Client("Patricia Flores", "patricf", 1234567900L, 3001234570L, "patricf@mail.com"));
        clientRepository.save(new Client("Andres Rios", "andresr", 1234567901L, 3001234571L, "andresr@mail.com"));
        clientRepository.save(new Client("Lucia Lopez", "lucial", 1234567902L, 3001234572L, "lucial@mail.com"));
        clientRepository.save(new Client("Pedro Morales", "pedrom", 1234567903L, 3001234573L, "pedrom@mail.com"));
        clientRepository.save(new Client("Sofia Jimenez", "sofia", 1234567904L, 3001234574L, "sofia@mail.com"));
        clientRepository.save(new Client("Manuel Ortiz", "manuel", 1234567905L, 3001234575L, "manuel@mail.com"));
        clientRepository.save(new Client("Daniela Vega", "danielv", 1234567906L, 3001234576L, "danielv@mail.com"));
        clientRepository.save(new Client("Felipe Cruz", "felip", 1234567907L, 3001234577L, "felip@mail.com"));
        clientRepository.save(new Client("Isabella Castro", "isabelc", 1234567908L, 3001234578L, "isabelc@mail.com"));
        clientRepository.save(new Client("Gabriel Molina", "gabrielm", 1234567909L, 3001234579L, "gabrielm@mail.com"));
        clientRepository.save(new Client("Valentina Reyes", "valentir", 1234567910L, 3001234580L, "valentir@mail.com"));
        clientRepository.save(new Client("Javier Aguilar", "javiera", 1234567911L, 3001234581L, "javiera@mail.com"));
        clientRepository.save(new Client("Natalia Vargas", "nataliav", 1234567912L, 3001234582L, "nataliav@mail.com"));
        clientRepository.save(new Client("Alejandro Paredes", "alepar", 1234567913L, 3001234583L, "alepar@mail.com"));
        clientRepository.save(new Client("Camila Montoya", "camilam", 1234567914L, 3001234584L, "camilam@mail.com"));
        clientRepository.save(new Client("Esteban Peña", "estep", 1234567915L, 3001234585L, "estep@mail.com"));
        clientRepository.save(new Client("Veronica Silva", "veros", 1234567916L, 3001234586L, "veros@mail.com"));
        clientRepository.save(new Client("Ricardo Medina", "ricardom", 1234567917L, 3001234587L, "ricardom@mail.com"));
        clientRepository.save(new Client("Monica Guerrero", "monicag", 1234567918L, 3001234588L, "monicag@mail.com"));
        clientRepository.save(new Client("Oscar Herrera", "oscarh", 1234567919L, 3001234589L, "oscarh@mail.com"));
        clientRepository.save(new Client("Paola Ortiz", "paolao", 1234567920L, 3001234590L, "paolao@mail.com"));
        clientRepository.save(new Client("Sebastian Lara", "seblara", 1234567921L, 3001234591L, "seblara@mail.com"));
        clientRepository.save(new Client("Elena Fuentes", "elenaf", 1234567922L, 3001234592L, "elenaf@mail.com"));
        clientRepository.save(new Client("Diego Mendez", "diegom", 1234567923L, 3001234593L, "diegom@mail.com"));
        clientRepository.save(new Client("Rosa Castro", "rosac", 1234567924L, 3001234594L, "rosac@mail.com"));
        clientRepository.save(new Client("Hector Pardo", "hectorp", 1234567925L, 3001234595L, "hectorp@mail.com"));
        clientRepository.save(new Client("Adriana Campos", "adrianac", 1234567926L, 3001234596L, "adrianac@mail.com"));
        clientRepository.save(new Client("Rodrigo Luna", "rodrluna", 1234567927L, 3001234597L, "rodrluna@mail.com"));
        clientRepository.save(new Client("Sara Valdez", "saraval", 1234567928L, 3001234598L, "saraval@mail.com"));
        clientRepository.save(new Client("Fernando Beltran", "fernandob", 1234567929L, 3001234599L, "fernandob@mail.com"));
        clientRepository.save(new Client("Irene Alvarez", "irenealv", 1234567930L, 3001234600L, "irenealv@mail.com"));
        clientRepository.save(new Client("Mario Espinosa", "marioesp", 1234567931L, 3001234601L, "marioesp@mail.com"));
        clientRepository.save(new Client("Alicia Rojas", "aliciar", 1234567932L, 3001234602L, "aliciar@mail.com"));
        clientRepository.save(new Client("Victor Pineda", "victorp", 1234567933L, 3001234603L, "victorp@mail.com"));
        clientRepository.save(new Client("Angela Mendoza", "angelam", 1234567934L, 3001234604L, "angelam@mail.com"));
        clientRepository.save(new Client("Jorge Suarez", "jorges", 1234567935L, 3001234605L, "jorges@mail.com"));
        clientRepository.save(new Client("Claudia Ortega", "claudiao", 1234567936L, 3001234606L, "claudiao@mail.com"));
        clientRepository.save(new Client("Rafael Zamora", "rafaelz", 1234567937L, 3001234607L, "rafaelz@mail.com"));
        clientRepository.save(new Client("Cecilia Navarro", "cecilian", 1234567938L, 3001234608L, "cecilian@mail.com"));
        clientRepository.save(new Client("Martin Castillo", "martinc", 1234567939L, 3001234609L, "martinc@mail.com"));
        clientRepository.save(new Client("María Castillo", "mcastillo", 1234567940L, 300123610L, "martinc@mail.com"));

    }

    public void createPets () {
        petRepository.save( new Pet("Perry", "French Poodle", 2, "Baño", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", clientRepository.findById(1L).get()));
        petRepository.save( new Pet("Lucas", "Labrador", 2, "Baño", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", clientRepository.findById(2L).get()));
        petRepository.save( new Pet("Zeus", "Golden Retriever", 2, "Tratamiento", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg", clientRepository.findById(3L).get()));
        petRepository.save( new Pet("Luna", "Sibersian Husky", 3, "Vacunación", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg", clientRepository.findById(2L).get()));
        petRepository.save( new Pet("Bella", "Bulldog Francés", 1, "Chequeo General", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg", clientRepository.findById(3L).get()));
        petRepository.save( new Pet("Max", "Pastor Alemán", 4, "Desparasitación", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg", clientRepository.findById(1L).get()));
        petRepository.save(new Pet("Charlie", "Bulldog Francés", 2, "Odontología veterinaria", 12.8, "https://4.bp.blogspot.com/-atz5WgBqCys/VxasgrWNCEI/AAAAAAAB9Ao/ClzFWC9eEEcOWygTP4l3m0rEXVpRTX1ggCKgB/s1600/Perritos-cachorros-162.jpg", clientRepository.findById(4L).get()));
        petRepository.save(new Pet("Rocky", "Beagle", 4, "Laboratorio y diagnóstico por Imágenes", 14.7, "https://www.anipedia.net/imagenes/que-comen-los-perros.jpg", clientRepository.findById(5L).get()));
        petRepository.save(new Pet("Lucy", "Poodle", 6, "Consultas y chequeos generales", 8.6, "https://www.blogerin.com/wp-content/uploads/2012/10/Fotos-tiernas-de-perritos-wallpapers-2.jpg", clientRepository.findById(6L).get()));
        petRepository.save(new Pet("Molly", "Boxer", 3, "Vacunaciones y Desparasitación", 23.5, "https://descargarimagenesgratis.org/wp-content/uploads/2014/09/Fotos-de-perros-jugando-7.jpg", clientRepository.findById(7L).get()));
        petRepository.save(new Pet("Buddy", "Rottweiler", 5, "Odontología veterinaria", 35.0, "https://www.elmueble.com/medio/2023/03/09/perro-de-raza-rottweiler_9f7a22a7_230309180127_900x900.jpg", clientRepository.findById(8L).get()));
        petRepository.save(new Pet("Daisy", "Chihuahua", 1, "Laboratorio y diagnóstico por Imágenes", 3.2, "https://noticiastu.com/wp-content/uploads/2017/01/99f9ede31328c8484e9e252d08811535.jpg", clientRepository.findById(9L).get()));
        petRepository.save(new Pet("Bailey", "Cocker Spaniel", 4, "Consultas y chequeos generales", 13.0, "https://png.pngtree.com/png-clipart/20231028/original/pngtree-bailey-dog-transparent-background-png-image_13446258.png", clientRepository.findById(10L).get()));
        petRepository.save(new Pet("Coco", "Border Collie", 3, "Vacunaciones y Desparasitación", 17.5, "https://3.bp.blogspot.com/-4fZ1pqkpsGc/UUFTVo_SZeI/AAAAAAAAA6w/3vFyEo7Ji30/s1600/5.jpg", clientRepository.findById(11L).get()));
        petRepository.save(new Pet("Oscar", "Dálmata", 5, "Odontología veterinaria", 25.3, "https://3.bp.blogspot.com/-oKoKqtEKPIo/T1gRb8epcWI/AAAAAAAAV90/zLxHcPblLi8/s1600/Perro-Beagle-en-el-Campo_01.jpg", clientRepository.findById(12L).get()));
        petRepository.save(new Pet("Ruby", "Husky Siberiano", 4, "Laboratorio y diagnóstico por Imágenes", 22.1, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(13L).get()));
        petRepository.save(new Pet("Rex", "Doberman", 6, "Consultas y chequeos generales", 30.0, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(14L).get()));
        petRepository.save(new Pet("Lola", "Bulldog Inglés", 2, "Vacunaciones y Desparasitación", 23.7, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(15L).get()));
        petRepository.save(new Pet("Buster", "Shih Tzu", 3, "Odontología veterinaria", 6.5, "https://www.petdarling.com/wp-content/uploads/2020/11/razas-de-perros.jpg", clientRepository.findById(16L).get()));
        petRepository.save(new Pet("Sadie", "Yorkshire Terrier", 4, "Laboratorio y diagnóstico por Imágenes", 4.0, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(17L).get()));
        petRepository.save(new Pet("Duke", "Pug", 5, "Consultas y chequeos generales", 9.5, "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", clientRepository.findById(18L).get()));
        petRepository.save(new Pet("Zoe", "Bichón Frisé", 2, "Vacunaciones y Desparasitación", 5.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(19L).get()));
        petRepository.save(new Pet("Jack", "Mastín", 4, "Odontología veterinaria", 40.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(20L).get()));
        petRepository.save(new Pet("Maggie", "Maltés", 3, "Laboratorio y diagnóstico por Imágenes", 4.5, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(21L).get()));
        petRepository.save(new Pet("Toby", "Akita", 6, "Consultas y chequeos generales", 32.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(22L).get()));
        petRepository.save(new Pet("Stella", "Bóxer", 5, "Vacunaciones y Desparasitación", 26.8, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(23L).get()));
        petRepository.save(new Pet("Bentley", "Schnauzer", 3, "Odontología veterinaria", 8.5, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(24L).get()));
        petRepository.save(new Pet("Chloe", "West Highland White Terrier", 4, "Laboratorio y diagnóstico por Imágenes", 7.5, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(25L).get()));
        petRepository.save(new Pet("Zeus", "Dogo Argentino", 5, "Consultas y chequeos generales", 38.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(26L).get()));
        petRepository.save(new Pet("Bruno", "Samoyedo", 3, "Vacunaciones y Desparasitación", 25.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(27L).get()));
        petRepository.save(new Pet("Nala", "Caniche", 2, "Odontología veterinaria", 4.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(28L).get()));
        petRepository.save(new Pet("Thor", "Terranova", 6, "Laboratorio y diagnóstico por Imágenes", 50.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(29L).get()));
        petRepository.save(new Pet("Leo", "Weimaraner", 4, "Consultas y chequeos generales", 29.0, "", clientRepository.findById(30L).get()));
        petRepository.save(new Pet("Ellie", "Shetland Sheepdog", 5, "Vacunaciones y Desparasitación", 7.5, "", clientRepository.findById(31L).get()));
        petRepository.save(new Pet("Riley", "Galgo", 3, "Odontología veterinaria", 25.5, "", clientRepository.findById(32L).get()));
        petRepository.save(new Pet("Lilly", "Basenji", 2, "Laboratorio y diagnóstico por Imágenes", 10.5, "", clientRepository.findById(33L).get()));
        petRepository.save(new Pet("Tucker", "Cane Corso", 4, "Consultas y chequeos generales", 42.0, "https://www.blogerin.com/wp-content/uploads/2012/10/Fotos-tiernas-de-perritos-wallpapers-2.jpg", clientRepository.findById(34L).get()));
        petRepository.save(new Pet("Ginger", "Galgo Italiano", 3, "Vacunaciones y Desparasitación", 6.2, "", clientRepository.findById(35L).get()));
        petRepository.save(new Pet("Rocco", "Lhasa Apso", 6, "Odontología veterinaria", 7.0, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(36L).get()));
        petRepository.save(new Pet("Layla", "Husky", 5, "Laboratorioy diagnóstico por Imágenes", 22.0, "", clientRepository.findById(37L).get())); 
        petRepository.save(new Pet("Murphy", "Galgo Afgano", 4, "Consultas y chequeos generales", 26.0, "", clientRepository.findById(38L).get())); 
        petRepository.save(new Pet("Nina", "Pinscher", 2, "Vacunaciones y Desparasitación", 4.5, "", clientRepository.findById(39L).get())); 
        petRepository.save(new Pet("Ollie", "Shar Pei", 3, "Odontología veterinaria", 23.5, "", clientRepository.findById(40L).get())); 
        petRepository.save(new Pet("Milo", "Galgo Español", 5, "Laboratorio y diagnóstico por Imágenes", 28.0, "", clientRepository.findById(41L).get())); 
        petRepository.save(new Pet("Sasha", "Collie", 6, "Consultas y chequeos generales", 22.5, "", clientRepository.findById(42L).get())); 
        petRepository.save(new Pet("Hunter", "Fox Terrier", 4, "Vacunaciones y Desparasitación", 8.0, "", clientRepository.findById(43L).get())); 
        petRepository.save(new Pet("Izzy", "Galgo Húngaro", 2, "Odontología veterinaria", 19.0, "https://www.anipedia.net/imagenes/que-comen-los-perros.jpg", clientRepository.findById(44L).get())); 
        petRepository.save(new Pet("Simba", "Husky", 3, "Laboratorio y diagnóstico por Imágenes", 22.0, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(45L).get())); 
        petRepository.save(new Pet("Beau", "Setter Irlandés", 5, "Consultas y chequeos generales", 27.0, "", clientRepository.findById(46L).get())); 
        petRepository.save(new Pet("Misty", "Shiba Inu", 3, "Vacunaciones y Desparasitación", 10.0, "", clientRepository.findById(47L).get())); 
        petRepository.save(new Pet("Ranger", "Vizsla", 4, "Odontología veterinaria", 24.5, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(48L).get())); 
        petRepository.save(new Pet("Lola", "Golden Retriever", 6, "Laboratorio y diagnóstico por Imágenes", 30.0, "", clientRepository.findById(49L).get()));
        petRepository.save(new Pet("Finn", "Border Collie", 2, "Vacunaciones y Desparasitación", 15.0, "", clientRepository.findById(1L).get()));
        petRepository.save(new Pet("Maya", "Jack Russell Terrier", 3, "Odontología veterinaria", 7.5, "", clientRepository.findById(2L).get()));
        petRepository.save(new Pet("Riley", "Husky Siberiano", 4, "Laboratorio y diagnóstico por Imágenes", 20.0, "", clientRepository.findById(3L).get()));
        petRepository.save(new Pet("Ziggy", "Bulldog Inglés", 5, "Consultas y chequeos generales", 24.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(4L).get()));
        petRepository.save(new Pet("Penny", "Cocker Spaniel", 3, "Vacunaciones y Desparasitación", 12.5, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(5L).get()));
        petRepository.save(new Pet("Rocky", "Rottweiler", 6, "Odontología veterinaria", 40.0, "https://descargarimagenesgratis.org/wp-content/uploads/2014/09/Fotos-de-perros-jugando-7.jpg", clientRepository.findById(6L).get()));
        petRepository.save(new Pet("Millie", "Golden Retriever", 2, "Laboratorio y diagnóstico por Imágenes", 25.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(7L).get()));
        petRepository.save(new Pet("Otis", "Dachshund", 4, "Consultas y chequeos generales", 9.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(8L).get()));
        petRepository.save(new Pet("Lulu", "Shih Tzu", 5, "Vacunaciones y Desparasitación", 7.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(9L).get()));
        petRepository.save(new Pet("Shadow", "Pastor Alemán", 3, "Odontología veterinaria", 30.0, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(10L).get()));
        petRepository.save(new Pet("Gus", "Bulldog Francés", 2, "Laboratorio y diagnóstico por Imágenes", 13.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(11L).get()));
        petRepository.save(new Pet("Maggie", "Cavalier King Charles Spaniel", 4, "Consultas y chequeos generales", 8.5, "", clientRepository.findById(12L).get()));
        petRepository.save(new Pet("Louie", "Beagle", 5, "Vacunaciones y Desparasitación", 14.0, "https://3.bp.blogspot.com/-4fZ1pqkpsGc/UUFTVo_SZeI/AAAAAAAAA6w/3vFyEo7Ji30/s1600/5.jpg", clientRepository.findById(13L).get()));
        petRepository.save(new Pet("Ginger", "Labrador Retriever", 3, "Odontología veterinaria", 22.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(14L).get()));
        petRepository.save(new Pet("Simba", "Akita", 6, "Laboratorio y diagnóstico por Imágenes", 35.0, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(15L).get()));
        petRepository.save(new Pet("Chester", "Boston Terrier", 2, "Consultas y chequeos generales", 10.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(16L).get()));
        petRepository.save(new Pet("Zara", "Corgi", 4, "Vacunaciones y Desparasitación", 13.5, "", clientRepository.findById(17L).get()));
        petRepository.save(new Pet("Dexter", "Boxer", 3, "Odontología veterinaria", 24.0, "", clientRepository.findById(18L).get()));
        petRepository.save(new Pet("Rex", "Dogo Argentino", 5, "Laboratorio y diagnóstico por Imágenes", 36.0, "", clientRepository.findById(19L).get()));
        petRepository.save(new Pet("Sadie", "Maltés", 2, "Consultas y chequeos generales", 4.0, "", clientRepository.findById(20L).get()));
        petRepository.save(new Pet("Winston", "Doberman", 6, "Vacunaciones y Desparasitación", 38.0, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(21L).get()));
        petRepository.save(new Pet("Sophie", "Pomerania", 3, "Odontología veterinaria", 5.5, "", clientRepository.findById(22L).get()));
        petRepository.save(new Pet("Bear", "Samoyedo", 4, "Laboratorio y diagnóstico por Imágenes", 30.0, "", clientRepository.findById(23L).get()));
        petRepository.save(new Pet("Ruby", "Pastor Australiano", 5, "Consultas y chequeos generales", 25.0, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(24L).get()));
        petRepository.save(new Pet("Murphy", "Bichón Frisé", 3, "Vacunaciones y Desparasitación", 6.0, "https://3.bp.blogspot.com/-oKoKqtEKPIo/T1gRb8epcWI/AAAAAAAAV90/zLxHcPblLi8/s1600/Perro-Beagle-en-el-Campo_01.jpg", clientRepository.findById(25L).get()));
        petRepository.save(new Pet("Harley", "Galgo", 4, "Odontología veterinaria", 28.0, "", clientRepository.findById(26L).get()));
        petRepository.save(new Pet("Bailey", "Rottweiler", 6, "Laboratorio y diagnóstico por Imágenes", 42.0, "", clientRepository.findById(27L).get()));
        petRepository.save(new Pet("Zoey", "Pastor Belga", 3, "Consultas y chequeos generales", 20.0, "", clientRepository.findById(28L).get()));
        petRepository.save(new Pet("Benny", "West Highland White Terrier", 5, "Vacunaciones y Desparasitación", 8.0, "", clientRepository.findById(29L).get()));
        petRepository.save(new Pet("Milo", "Cocker Spaniel", 4, "Odontología veterinaria", 13.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(30L).get()));
        petRepository.save(new Pet("Teddy", "Pastor de Anatolia", 3, "Laboratorio y diagnóstico por Imágenes", 28.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(31L).get()));
        petRepository.save(new Pet("Coco", "Yorkshire Terrier", 6, "Consultas y chequeos generales", 3.5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(32L).get()));
        petRepository.save(new Pet("Hazel", "Galgo Húngaro", 4, "Vacunaciones y Desparasitación", 18.0, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(33L).get()));
        petRepository.save(new Pet("Blue", "Labrador Retriever", 2, "Odontología veterinaria", 22.5, "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", clientRepository.findById(34L).get()));
        petRepository.save(new Pet("Gracie", "Husky", 5, "Laboratorio y diagnóstico por Imágenes", 27.0, "https://www.elmueble.com/medio/2023/03/09/perro-de-raza-rottweiler_9f7a22a7_230309180127_900x900.jpg", clientRepository.findById(35L).get()));
        petRepository.save(new Pet("Bentley", "Collie", 3, "Consultas y chequeos generales", 23.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(36L).get()));
        petRepository.save(new Pet("Nala", "Shiba Inu", 4, "Vacunaciones y Desparasitación", 10.5, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(37L).get()));
        petRepository.save(new Pet("Rusty", "Galgo Italiano", 3, "Odontología veterinaria", 19.0, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(38L).get()));
        petRepository.save(new Pet("Ellie", "Setter Inglés", 5, "Laboratorio y diagnóstico por Imágenes", 25.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(39L).get()));
        petRepository.save(new Pet("Maddie", "Border Collie", 2, "Consultas y chequeos generales", 17.0, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(40L).get()));
        petRepository.save(new Pet("Moose", "Dálmata", 6, "Vacunaciones y Desparasitación", 24.5, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(41L).get()));
        petRepository.save(new Pet("Lily", "Galgo Español", 3, "Odontología veterinaria", 29.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(42L).get()));
        petRepository.save(new Pet("Apollo", "Fox Terrier", 4, "Laboratorio y diagnóstico por Imágenes", 7.5, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(43L).get()));
        petRepository.save(new Pet("Chloe", "Galgo Afgano", 5, "Consultas y chequeos generales", 26.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(44L).get()));
        petRepository.save(new Pet("Scout", "Jack Russell Terrier", 3, "Vacunaciones y Desparasitación", 9.0, "https://www.petdarling.com/wp-content/uploads/2020/11/razas-de-perros.jpg", clientRepository.findById(45L).get()));
        petRepository.save(new Pet("Buddy", "Pastor Belga", 6, "Odontología veterinaria", 34.0, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(46L).get()));
        petRepository.save(new Pet("Lola", "Cocker Spaniel", 4, "Laboratorio y diagnóstico por Imágenes", 14.0, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(47L).get()));
        petRepository.save(new Pet("Archie", "Setter Irlandés", 3, "Consultas y chequeos generales", 28.0, "https://content.elmueble.com/medio/2023/03/30/perro-labrador-retriever_5e8d307f_230330133647_900x900.jpg", clientRepository.findById(48L).get()));
        petRepository.save(new Pet("Bella", "Galgo Húngaro", 5, "Vacunaciones y Desparasitación", 20.5, "https://noticiastu.com/wp-content/uploads/2017/01/99f9ede31328c8484e9e252d08811535.jpg", clientRepository.findById(49L).get()));

    }
    
}
