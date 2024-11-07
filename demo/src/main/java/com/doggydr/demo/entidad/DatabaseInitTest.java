package com.doggydr.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.io.File;

import com.doggydr.demo.repositorio.*;
import com.doggydr.demo.utils.MedicineExcelLoader;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("test")
public class DatabaseInitTest implements ApplicationRunner {


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

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Añadiendo los clientes al repositorio
        createClients();

        // Añadir mascotas
        createPets();

        // Añadir administradores
        adminRepository.save(new Admin(null, null, "Juan Sebastian", "juanSe", "angarita"));

        // Añadir servicios
        serviceRepository.save(new Service("Consultas y chequeos generales", 20.500));
        serviceRepository.save(new Service("Vacunaciones y Desparasitación", 50.500));
        serviceRepository.save(new Service("Odontología veterinaria", 120.500));
        serviceRepository.save(new Service("Laboratorio y diagnóstico por Imágenes", 80.500));

        // Añadir veterinarios
        createVets();

        // Añador medicinas
        createMedicine();

        // Añadir tratamientos
        createTreatment();
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
        petRepository.save(new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", clientRepository.findById(1L).get(),true));
        petRepository.save(new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", clientRepository.findById(2L).get(),true));
        petRepository.save(new Pet("Zeus", "Golden Retriever", 2, "Displasia de cadera", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg", clientRepository.findById(3L).get(),true));
        petRepository.save(new Pet("Luna", "Siberian Husky", 3, "Sarna", 10.5, "https://www.dogster.com/wp-content/uploads/2024/01/siberian-husky-dog-standing-on-grass_Edalin-Photograhy_Shutterstock.jpeg", clientRepository.findById(2L).get(),true));
        petRepository.save(new Pet("Bella", "Bulldog Francés", 1, "Alergias", 7.0, "https://t2.ea.ltmcdn.com/es/posts/4/4/2/cuantos_cachorros_puede_tener_un_bulldog_frances_24244_orig.jpg", clientRepository.findById(3L).get(), true));
        petRepository.save(new Pet("Max", "Pastor Alemán", 4, "Dermatitis", 11.0, "https://i.blogs.es/a9adf6/kinshuk-bose-pkgzncmkdxo-unsplash/450_1000.jpeg", clientRepository.findById(1L).get(), true));
        petRepository.save(new Pet("Charlie", "Bulldog Francés", 2, "Problemas respiratorios", 12.8, "https://4.bp.blogspot.com/-atz5WgBqCys/VxasgrWNCEI/AAAAAAAB9Ao/ClzFWC9eEEcOWygTP4l3m0rEXVpRTX1ggCKgB/s1600/Perritos-cachorros-162.jpg", clientRepository.findById(4L).get(), true));
        petRepository.save(new Pet("Rocky", "Beagle", 4, "Problemas cardíacos", 14.7, "https://www.anipedia.net/imagenes/que-comen-los-perros.jpg", clientRepository.findById(5L).get(), true));
        petRepository.save(new Pet("Lucy", "Poodle", 6, "Epilepsia", 8.6, "https://www.blogerin.com/wp-content/uploads/2012/10/Fotos-tiernas-de-perritos-wallpapers-2.jpg", clientRepository.findById(6L).get(), true));
        petRepository.save(new Pet("Molly", "Boxer", 3, "Tumores", 23.5, "https://descargarimagenesgratis.org/wp-content/uploads/2014/09/Fotos-de-perros-jugando-7.jpg", clientRepository.findById(7L).get(), true));
        petRepository.save(new Pet("Buddy", "Rottweiler", 5, "Osteosarcoma", 35.0, "https://www.elmueble.com/medio/2023/03/09/perro-de-raza-rottweiler_9f7a22a7_230309180127_900x900.jpg", clientRepository.findById(8L).get(), true));
        petRepository.save(new Pet("Daisy", "Chihuahua", 1, "Luxación de rótula", 3.2, "https://noticiastu.com/wp-content/uploads/2017/01/99f9ede31328c8484e9e252d08811535.jpg", clientRepository.findById(9L).get(), true));
        petRepository.save(new Pet("Bailey", "Cocker Spaniel", 4, "Otitis externa", 13.0, "https://png.pngtree.com/png-clipart/20231028/original/pngtree-bailey-dog-transparent-background-png-image_13446258.png", clientRepository.findById(10L).get(), true));
        petRepository.save(new Pet("Coco", "Border Collie", 3, "Ceguera progresiva", 17.5, "https://3.bp.blogspot.com/-4fZ1pqkpsGc/UUFTVo_SZeI/AAAAAAAAA6w/3vFyEo7Ji30/s1600/5.jpg", clientRepository.findById(11L).get(), true));
        petRepository.save(new Pet("Oscar", "Dálmata", 5, "Sordera congénita", 25.3, "https://3.bp.blogspot.com/-oKoKqtEKPIo/T1gRb8epcWI/AAAAAAAAV90/zLxHcPblLi8/s1600/Perro-Beagle-en-el-Campo_01.jpg", clientRepository.findById(12L).get(), true));
        petRepository.save(new Pet("Ruby", "Husky Siberiano", 4, "Problemas de visión", 22.1, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(13L).get(), true));
        petRepository.save(new Pet("Rex", "Doberman", 6, "Displasia de cadera", 30.0, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(14L).get(), true));
        petRepository.save(new Pet("Lola", "Bulldog Inglés", 2, "Problemas respiratorios", 23.7, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(15L).get(), true));
        petRepository.save(new Pet("Buster", "Shih Tzu", 3, "Problemas oculares", 6.5, "https://www.petdarling.com/wp-content/uploads/2020/11/razas-de-perros.jpg", clientRepository.findById(16L).get(), true));
        petRepository.save(new Pet("Sadie", "Yorkshire Terrier", 4, "Luxación rotuliana", 4.0, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(17L).get(), true));
        petRepository.save(new Pet("Duke", "Pug", 5, "Problemas respiratorios", 9.5, "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", clientRepository.findById(18L).get(), true));
        petRepository.save(new Pet("Zoe", "Bichón Frisé", 2, "Alergias cutáneas", 5.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(19L).get(), true));
        petRepository.save(new Pet("Jack", "Mastín", 4, "Problemas articulares", 40.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(20L).get(), true));
        petRepository.save(new Pet("Maggie", "Maltés", 3, "Problemas dentales", 4.5, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(21L).get(),true));
        petRepository.save(new Pet("Toby", "Akita", 6, "Hipotiroidismo", 32.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(22L).get(),true));
        petRepository.save(new Pet("Stella", "Bóxer", 5, "Cardiomiopatía", 26.8, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(23L).get(),true));
        petRepository.save(new Pet("Bentley", "Schnauzer", 3, "Problemas oculares", 8.5, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(24L).get(),true));
        petRepository.save(new Pet("Chloe", "West Highland White Terrier", 4, "Problemas de piel", 7.5, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(25L).get(), true));
        petRepository.save(new Pet("Zeus", "Dogo Argentino", 5, "Sordera", 38.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(26L).get(), true));
        petRepository.save(new Pet("Bruno", "Samoyedo", 3, "Problemas articulares", 25.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(27L).get(), true));
        petRepository.save(new Pet("Nala", "Caniche", 2, "Problemas dentales", 4.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(28L).get(), true));
        petRepository.save(new Pet("Thor", "Terranova", 6, "Displasia de cadera", 50.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(29L).get(), true));
        petRepository.save(new Pet("Leo", "Weimaraner", 4, "Problemas articulares", 29.0, "https://www.hundeo.com/wp-content/uploads/2019/02/Weimaraner-Portra%CC%88t-.jpg", clientRepository.findById(30L).get(), true));
        petRepository.save(new Pet("Ellie", "Shetland Sheepdog", 5, "Problemas oculares", 7.5, "https://geniusvets.s3.amazonaws.com/gv-dog-breeds/shetland-sheepdog-3.jpg", clientRepository.findById(31L).get(), true));
        petRepository.save(new Pet("Riley", "Galgo", 3, "Problemas cardíacos", 25.5, "https://cdn.unotv.com/images/2024/01/caracteristicas-del-galgo-jpg-173130.jpg", clientRepository.findById(32L).get(), true));
        petRepository.save(new Pet("Lilly", "Basenji", 2, "Problemas de piel", 10.5, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-08basenji.jpg?itok=0cbpZJgV", clientRepository.findById(33L).get(), true));
        petRepository.save(new Pet("Tucker", "Cane Corso", 4, "Displasia de cadera", 42.0, "https://www.blogerin.com/wp-content/uploads/2012/10/Fotos-tiernas-de-perritos-wallpapers-2.jpg", clientRepository.findById(34L).get(), true));
        petRepository.save(new Pet("Ginger", "Galgo Italiano", 3, "Problemas cardíacos", 6.2, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Italian_Greyhound_standing_gray.jpg/320px-Italian_Greyhound_standing_gray.jpg", clientRepository.findById(35L).get(), true));
        petRepository.save(new Pet("Rocco", "Lhasa Apso", 6, "Problemas dentales", 7.0, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(36L).get(), true));
        petRepository.save(new Pet("Layla", "Husky", 5, "Problemas oculares", 22.0, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-08Siberian20Husky2.jpg?itok=d5njFuxB", clientRepository.findById(37L).get(), true));
        petRepository.save(new Pet("Murphy", "Galgo Afgano", 4, "Problemas cardíacos", 26.0, "https://i.pinimg.com/736x/46/0a/fb/460afb0cc53180384e1c91cf5dac30c1.jpg", clientRepository.findById(38L).get(), true));
        petRepository.save(new Pet("Nina", "Pinscher", 2, "Problemas dentales", 4.5, "https://upload.wikimedia.org/wikipedia/commons/1/13/Pinscher_Miniatura_l%C3%ADnea_Europea_en_Cuernavaca_M%C3%A9xico_2.jpg", clientRepository.findById(39L).get(), true));
        petRepository.save(new Pet("Ollie", "Shar Pei", 3, "Odontología veterinaria", 23.5, "https://miro.medium.com/v2/resize:fit:800/1*otu_l6kwSn-L-WhRaFcQIQ.jpeg", clientRepository.findById(40L).get(), true));     
        petRepository.save(new Pet("Milo", "Galgo Español", 5, "Displasia de cadera", 28.0, "https://www.kiwoko.com/blogmundoanimal/wp-content/uploads/2024/03/galgo-espanol-raza.jpg", clientRepository.findById(41L).get(), true)); 
        petRepository.save(new Pet("Sasha", "Collie", 6, "Atrofia progresiva de retina", 22.5, "https://www.worldlifeexpectancy.com//images/a/d/d/b/collie_rough/collie_rough_1.webp", clientRepository.findById(42L).get(), true)); 
        petRepository.save(new Pet("Hunter", "Fox Terrier", 4, "Luxación de rótula", 8.0, "https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0050_fox_terrier_wire.jpg", clientRepository.findById(43L).get(), true)); 
        petRepository.save(new Pet("Izzy", "Galgo Húngaro", 2, "Enfermedad periodontal", 19.0, "https://www.anipedia.net/imagenes/que-comen-los-perros.jpg", clientRepository.findById(44L).get(), true)); 
        petRepository.save(new Pet("Simba", "Husky", 3, "Glaucoma", 22.0, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(45L).get(), true)); 
        petRepository.save(new Pet("Beau", "Setter Irlandés", 5, "Torsión gástrica", 27.0, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Can_Setter_dog_GFDL.jpg/800px-Can_Setter_dog_GFDL.jpg", clientRepository.findById(46L).get(), true)); 
        petRepository.save(new Pet("Misty", "Shiba Inu", 3, "Alergias cutáneas", 10.0, "https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2024/04/08/66141a09dbe9d.r_d.2338-1390-3106.jpeg", clientRepository.findById(47L).get(), true)); 
        petRepository.save(new Pet("Ranger", "Vizsla", 4, "Displasia de codo", 24.5, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(48L).get(), true)); 
        petRepository.save(new Pet("Lola", "Golden Retriever", 6, "Problemas de tiroides", 30.0, "https://13630656.rocketcdn.me/wp-content/uploads/2020/01/Golden4.jpg", clientRepository.findById(49L).get(), true));
        petRepository.save(new Pet("Finn", "Border Collie", 2, "Epilepsia", 15.0, "https://images.ctfassets.net/550nf1gumh01/6dWe4W0fQAJNbTT2GOVoOv/15f5188d1867ea7bdcf5b610d0a699c7/iStock-1420601907.jpg?q=90&w=1240", clientRepository.findById(1L).get(), true));
        petRepository.save(new Pet("Maya", "Jack Russell Terrier", 3, "Luxación de rótula", 7.5, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Parson20Russell20Terrier.jpg?itok=8gUiayIr", clientRepository.findById(2L).get(), true));
        petRepository.save(new Pet("Riley", "Husky Siberiano", 4, "Problemas renales", 20.0, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Siberian20Husky.jpg?itok=JMtF4wzk", clientRepository.findById(3L).get(), true));
        petRepository.save(new Pet("Ziggy", "Bulldog Inglés", 5, "Problemas respiratorios", 24.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(4L).get(), true));
        petRepository.save(new Pet("Penny", "Cocker Spaniel", 3, "Otitis", 12.5, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(5L).get(), true));
        petRepository.save(new Pet("Rocky", "Rottweiler", 6, "Enfermedad periodontal", 40.0, "https://descargarimagenesgratis.org/wp-content/uploads/2014/09/Fotos-de-perros-jugando-7.jpg", clientRepository.findById(6L).get(), true));
        petRepository.save(new Pet("Millie", "Golden Retriever", 2, "Displasia de cadera", 25.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(7L).get(), true));
        petRepository.save(new Pet("Otis", "Dachshund", 4, "Hernia discal", 9.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(8L).get(), true));
        petRepository.save(new Pet("Lulu", "Shih Tzu", 5, "Infecciones oculares", 7.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(9L).get(), true));
        petRepository.save(new Pet("Shadow", "Pastor Alemán", 3, "Displasia de cadera", 30.0, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(10L).get(), true));
        petRepository.save(new Pet("Gus", "Bulldog Francés", 2, "Problemas respiratorios", 13.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(11L).get(), true));
        petRepository.save(new Pet("Maggie", "Cavalier King Charles Spaniel", 4, "Problemas cardíacos", 8.5, "https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0032_king_charles_spaniel.jpg", clientRepository.findById(12L).get(), true));
        petRepository.save(new Pet("Louie", "Beagle", 5, "Epilepsia", 14.0, "https://3.bp.blogspot.com/-4fZ1pqkpsGc/UUFTVo_SZeI/AAAAAAAAA6w/3vFyEo7Ji30/s1600/5.jpg", clientRepository.findById(13L).get(), true));
        petRepository.save(new Pet("Ginger", "Labrador Retriever", 3, "Obesidad", 22.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(14L).get(), true));
        petRepository.save(new Pet("Simba", "Akita", 6, "Infección de oído", 35.0, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(15L).get(), true));
        petRepository.save(new Pet("Chester", "Boston Terrier", 2, "Problemas respiratorios", 10.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(16L).get(), true));
        petRepository.save(new Pet("Zara", "Corgi", 4, "Displasia de cadera", 13.5, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Welsh_Pembroke_Corgi.jpg/800px-Welsh_Pembroke_Corgi.jpg", clientRepository.findById(17L).get(), true));
        petRepository.save(new Pet("Dexter", "Boxer", 3, "Enfermedad periodontal", 24.0, "https://www.tiendanimal.es/articulos/wp-content/uploads/2020/07/boxer-cachorro-1200x900.jpg", clientRepository.findById(18L).get(), true));
        petRepository.save(new Pet("Rex", "Dogo Argentino", 5, "Displasia de cadera", 36.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUgYX9zTSdHzFWebeKOMvZUke3-j1BydGJ2Q&s", clientRepository.findById(19L).get(), true));
        petRepository.save(new Pet("Sadie", "Maltés", 2, "Hernia discal", 4.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZaKMJ9l2NXSjN65j5lQo2iGT57kh9JH7xQA&s", clientRepository.findById(20L).get(), true));
        petRepository.save(new Pet("Winston", "Doberman", 6, "Infección de oído", 38.0, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(21L).get(), true));
        petRepository.save(new Pet("Sophie", "Pomerania", 3, "Problemas cardíacos", 5.5, "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/AZFUICR3VVGMBJQIHNZAD47ILU.jpg", clientRepository.findById(22L).get(), true));
        petRepository.save(new Pet("Bear", "Samoyedo", 4, "Epilepsia", 30.0, "https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0110_samoyed.jpg", clientRepository.findById(23L).get(), true));
        petRepository.save(new Pet("Ruby", "Pastor Australiano", 5, "Obesidad", 25.0, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(24L).get(), true));
        petRepository.save(new Pet("Murphy", "Bichón Frisé", 3, "Infección de oído", 6.0, "https://3.bp.blogspot.com/-oKoKqtEKPIo/T1gRb8epcWI/AAAAAAAAV90/zLxHcPblLi8/s1600/Perro-Beagle-en-el-Campo_01.jpg", clientRepository.findById(25L).get(), true));
        petRepository.save(new Pet("Harley", "Galgo", 4, "Displasia de cadera", 28.0, "https://elgalgoazul.com/wp-content/uploads/2023/03/curiosidades-sobre-los-galgos-scaled.jpg", clientRepository.findById(26L).get(), true));
        petRepository.save(new Pet("Bailey", "Rottweiler", 6, "Problemas respiratorios", 42.0, "https://www.elmueble.com/medio/2023/03/09/perro-de-raza-rottweiler-bebe_4aca739b_230309175845_1000x667.jpg", clientRepository.findById(27L).get(), true));
        petRepository.save(new Pet("Zoey", "Pastor Belga", 3, "Problemas respiratorios", 20.0, "https://nfnatcane.es/blog/wp-content/uploads/2020/07/Pastor-Belga-Groenendael.jpg", clientRepository.findById(28L).get(), true));
        petRepository.save(new Pet("Benny", "West Highland White Terrier", 5, "Infección de oído", 8.0, "https://www.zooplus.es/magazine/wp-content/uploads/2020/01/west-highland-white-terrier.jpg", clientRepository.findById(29L).get(), true));
        petRepository.save(new Pet("Milo", "Cocker Spaniel", 4, "Obesidad", 13.0, "https://okdiario.com/img/2024/08/29/un-estudio-confirma-que-los-perros-cada-vez-son-mas-tontos-y-es-culpa-de-sus-duenos-635x358.jpg", clientRepository.findById(30L).get(), true));
        petRepository.save(new Pet("Teddy", "Pastor de Anatolia", 3, "Problemas respiratorios", 28.0, "https://cdn2.dineroenimagen.com/1024x768/filters:format(jpg):quality(75)/media/dinero/images/2022/01/perros-economicos.jpg", clientRepository.findById(31L).get(), true));
        petRepository.save(new Pet("Coco", "Yorkshire Terrier", 6, "Enfermedad periodontal", 3.5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZZxhReu_lJXwL3wxhikwSr50UahNvG6sdYw&s", clientRepository.findById(32L).get(), true));
        petRepository.save(new Pet("Hazel", "Galgo Húngaro", 4, "Problemas de piel", 18.0, "https://okdiario.com/img/2021/05/08/mejores-perros-guardianes-655x368.jpg", clientRepository.findById(33L).get(), true));
        petRepository.save(new Pet("Blue", "Labrador Retriever", 2, "Displasia de cadera", 22.5, "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", clientRepository.findById(34L).get(), true));
        petRepository.save(new Pet("Gracie", "Husky", 5, "Problemas oculares", 27.0, "https://www.elmueble.com/medio/2023/03/09/perro-de-raza-rottweiler_9f7a22a7_230309180127_900x900.jpg", clientRepository.findById(35L).get(), true));
        petRepository.save(new Pet("Bentley", "Collie", 3, "Hipoalergia", 23.0, "https://es.onlyfresh.com/cdn/shop/articles/dog-g6aa17498a_1920_1024x.jpg?v=1659454762", clientRepository.findById(36L).get(), true));
        petRepository.save(new Pet("Nala", "Shiba Inu", 4, "Obesidad", 10.5, "https://static.laverdad.es/www/multimedia/202110/14/media/perrete.jpg", clientRepository.findById(37L).get(), true));
        petRepository.save(new Pet("Rusty", "Galgo Italiano", 3, "Infección de oído", 19.0, "https://www.nutrisslovers.com/Portals/nutrisslovers/Aticulos/Tipos-de-perros-de-terapia/Tipos-de-perros-de-terapia.jpg?ver=2022-09-30-131215-740", clientRepository.findById(38L).get(), true));
        petRepository.save(new Pet("Ellie", "Setter Inglés", 5, "Problemas respiratorios", 25.0, "https://media.es.wired.com/photos/65845b5ea4076464da362974/16:9/w_2560%2Cc_limit/Science-Life-Extension-Drug-for-Big-Dogs-Is-Getting-Closer-1330545769.jpg", clientRepository.findById(39L).get(), true));
        petRepository.save(new Pet("Maddie", "Border Collie", 2, "Problemas digestivos", 17.0, "https://shorthand-social.imgix.net/prod/story/ng77nuNXYR/media/6dca4600467911e88355bb16983c6639/original.jpg?w=1100&h=1100&fit=clip&fm=jpg&q=70&auto=format", clientRepository.findById(40L).get(), true));
        petRepository.save(new Pet("Moose", "Dálmata", 6, "Problemas cardíacos", 24.5, "https://www.teorema.com.mx/wp-content/uploads/perros.jpg", clientRepository.findById(41L).get(), true));
        petRepository.save(new Pet("Lily", "Galgo Español", 3, "Enfermedad periodontal", 29.0, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/04/bichon-maltes.jpg", clientRepository.findById(42L).get(), true));
        petRepository.save(new Pet("Apollo", "Fox Terrier", 4, "Problemas de piel", 7.5, "https://animaleshoy.net/wp-content/uploads/2014/04/cachorros_6.jpg", clientRepository.findById(43L).get(), true));
        petRepository.save(new Pet("Chloe", "Galgo Afgano", 5, "Problemas oculares", 26.0, "https://content.nationalgeographic.com.es/medio/2023/11/29/golden-retriever-corriendo_7a50f15e_231129131211_800x800.jpg", clientRepository.findById(44L).get(), true));
        petRepository.save(new Pet("Scout", "Jack Russell Terrier", 3, "Displasia de cadera", 9.0, "https://www.petdarling.com/wp-content/uploads/2020/11/razas-de-perros.jpg", clientRepository.findById(45L).get(), true));
        petRepository.save(new Pet("Buddy", "Pastor Belga", 6, "Problemas respiratorios", 34.0, "https://i.pinimg.com/originals/5f/35/2c/5f352c6080b6692e617205032083635c.jpg", clientRepository.findById(46L).get(), true));
        petRepository.save(new Pet("Lola", "Cocker Spaniel", 4, "Problemas digestivos", 14.0, "https://4.bp.blogspot.com/-pesA5apnrsQ/UUMssTjasJI/AAAAAAAABHo/kG_BJ67BW7g/s1600/fotos-imagenes-tiernas%2B(60).jpg", clientRepository.findById(47L).get(), true));
        petRepository.save(new Pet("Archie", "Setter Irlandés", 3, "Hipoalergia", 28.0, "https://content.elmueble.com/medio/2023/03/30/perro-labrador-retriever_5e8d307f_230330133647_900x900.jpg", clientRepository.findById(48L).get(), true));
        petRepository.save(new Pet("Bella", "Galgo Húngaro", 5, "Obesidad", 20.5, "https://noticiastu.com/wp-content/uploads/2017/01/99f9ede31328c8484e9e252d08811535.jpg", clientRepository.findById(49L).get(), true));

    }
    
    public void createVets() {
        vetRepository.save(new Vet("Daniel Carvajal", "General", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "daniC", 10131415L, 310123123, "daniel@gmail.com", "passDaniel", true));
        vetRepository.save(new Vet("Valentina Garcia", "Cirugía", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "valeG", 20212223L, 310321321, "valentina@gmail.com", "passValentina", false));
        vetRepository.save(new Vet("Santiago Martínez", "Dermatología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "santiM", 30312234L, 310456789, "santiago@gmail.com", "passSantiago", true));
        vetRepository.save(new Vet("Lucía Hernández", "Neurología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "luciaH", 40423345L, 310987654, "lucia@gmail.com", "passLucia", false));
        vetRepository.save(new Vet("Carlos López", "Cardiología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "carlosL", 50534456L, 310654321, "carlos@gmail.com", "passCarlos", true));
        vetRepository.save(new Vet("Camila Ruiz", "Oftalmología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "camilaR", 60645567L, 310789456, "camila@gmail.com", "passCamila", false));
        vetRepository.save(new Vet("Sebastián Gutiérrez", "Traumatología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "sebasG", 70756678L, 310123789, "sebastian@gmail.com", "passSebastian", true));
        vetRepository.save(new Vet("Ana María Ríos", "Odontología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "anaR", 80867789L, 310321654, "ana@gmail.com", "passAna", false));
        vetRepository.save(new Vet("Tomás Ramírez", "Ortopedia", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "tomasR", 90978890L, 310456123, "tomas@gmail.com", "passTomas", true));
        vetRepository.save(new Vet("Paula Sánchez", "Oncología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "paulaS", 10101112L, 310789321, "paula@gmail.com", "passPaula", false));
        vetRepository.save(new Vet("Diego Torres", "Anestesiología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "diegoT", 11121223L, 310654987, "diego@gmail.com", "passDiego", true));
        vetRepository.save(new Vet("Carolina Moreno", "Urgencias", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "carolinaM", 12131334L, 310987123, "carolina@gmail.com", "passCarolina", false));
        vetRepository.save(new Vet("Miguel Fernández", "Rehabilitación", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "miguelF", 13141445L, 310123654, "miguel@gmail.com", "passMiguel", true));
        vetRepository.save(new Vet("Isabella Jiménez", "Pediatría", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "isabellaJ", 14151556L, 310321987, "isabella@gmail.com", "passIsabella", false));
        vetRepository.save(new Vet("Andrés Suárez", "Geriatría", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "andresS", 15161667L, 310456789, "andres@gmail.com", "passAndres", true));
        vetRepository.save(new Vet("Daniela Gómez", "Nefrología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "danielaG", 16171778L, 310789654, "daniela@gmail.com", "passDaniela", false));
        vetRepository.save(new Vet("Gabriel Díaz", "Endocrinología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "gabrielD", 17181889L, 310654123, "gabriel@gmail.com", "passGabriel", true));
        vetRepository.save(new Vet("Sara Molina", "Hematología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "saraM", 18191990L, 310987321, "sara@gmail.com", "passSara", false));
        vetRepository.save(new Vet("Juan Pérez", "Inmunología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "juanP", 19202001L, 310123987, "juan@gmail.com", "passJuan", true));
        vetRepository.save(new Vet("María Castro", "Patología", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "mariaC", 20212112L, 310321654, "maria@gmail.com", "passMaria", false));
        vetRepository.save(new Vet("Felipe Aguilar", "Nutrición", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "felipeA", 21222223L, 310456987, "felipe@gmail.com", "passFelipe", true));
        vetRepository.save(new Vet("Mónica Díaz", "Genética", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "monicaD", 22232334L, 310789123, "monica@gmail.com", "passMonica", false));        
    }
    
    

    public void createMedicine() {
        // Medicine(String name, int availableUnits, int soldUnits, Double cost, Double salesPrice)
        
        String filePathLorena = "C:\\Personales\\Loretta\\6 Semestre\\Web\\Doggy-Dr\\MEDICAMENTOS_VETERINARIA.xlsx";
        String filePathDaniel = "C:\\Users\\DANIEL\\Documents\\Semestres\\Sexto semestre\\Desarrollo Web\\Proyecto\\Doggy-Dr\\MEDICAMENTOS_VETERINARIA.xlsx";
        String filePathNico = "C:\\Users\\nikit\\Documents\\UNIVERSIDAD\\Sexto Semestre\\Web Grupo 2\\Doggy-Dr-main\\MEDICAMENTOS_VETERINARIA.xlsx";        
        String filePathValentina = "C:\\Users\\Valentina\\Web\\Doggy-Dr\\MEDICAMENTOS_VETERINARIA.xlsx";
    
        MedicineExcelLoader loader = new MedicineExcelLoader();
        
        File file = new File(filePathLorena);
        
        // Primero intenta con la ruta de Lorena
        if (file.exists()) {
            System.out.println("Archivo encontrado en la ruta de Lorena.");
        } else {
            System.out.println("Archivo no encontrado en la ruta de Lorena. Intentando con la ruta de Daniel...");
            file = new File(filePathDaniel);
            if (file.exists()) {
                System.out.println("Archivo encontrado en la ruta de Daniel.");
            } else {
                System.out.println("Archivo no encontrado en la ruta de Daniel. Intentando con la ruta de Nico...");
                file = new File(filePathNico);
                if (file.exists()) {
                    System.out.println("Archivo encontrado en la ruta de Nico.");
                } else {
                    System.out.println("Archivo no encontrado en la ruta de Nico. Intentando con la ruta de Valentina...");
                    file = new File(filePathValentina);
                    if (file.exists()) {
                        System.out.println("Archivo encontrado en la ruta de Valentina.");
                    } else {
                        System.out.println("Archivo no encontrado en ninguna ruta.");
                        // Maneja el caso en que ninguna ruta funcione
                        return;
                    }
                }
            }
        }
        
        // Si el archivo existe en alguna de las rutas, se cargan los datos
        List<Medicine> medicines = loader.readMedicinesFromExcel(file.getAbsolutePath());

        // Guardar las medicinas en la base de datos
        medicineRepository.saveAll(medicines);

        /* 
        medicineRepository.save(new Medicine("Paracetamol", 100, 50, 0.50, 1.00));
        medicineRepository.save(new Medicine("Ibuprofeno", 200, 120, 0.30, 0.80));
        medicineRepository.save(new Medicine("Amoxicilina", 150, 80, 0.70, 1.50));
        medicineRepository.save(new Medicine("Aspirina", 300, 150, 0.25, 0.75));
        medicineRepository.save(new Medicine("Cetirizina", 50, 30, 0.60, 1.20));
        medicineRepository.save(new Medicine("Metformina", 250, 140, 0.40, 1.10));
        medicineRepository.save(new Medicine("Insulina", 100, 90, 2.50, 4.00));
        medicineRepository.save(new Medicine("Loratadina", 80, 40, 0.55, 1.00));
        medicineRepository.save(new Medicine("Omeprazol", 180, 100, 0.45, 1.25));
        medicineRepository.save(new Medicine("Clorfenamina", 120, 60, 0.35, 0.85));
        */
    }

    public void createTreatment() {
        // Obtener los medicamentos previamente guardados
        List<Medicine> medicine1 = Arrays.asList(
            medicineRepository.findById(1L).orElse(null),
            medicineRepository.findById(2L).orElse(null)
        );
        
        List<Medicine> medicine2 = Arrays.asList(
            medicineRepository.findById(3L).orElse(null),
            medicineRepository.findById(4L).orElse(null)
        );
        
        List<Medicine> medicine3 = Arrays.asList(
            medicineRepository.findById(5L).orElse(null),
            medicineRepository.findById(6L).orElse(null)
        );
        
        List<Medicine> medicine4 = Arrays.asList(
            medicineRepository.findById(7L).orElse(null),
            medicineRepository.findById(8L).orElse(null)
        );

        List<Medicine> medicine5 = Arrays.asList(
            medicineRepository.findById(9L).orElse(null),
            medicineRepository.findById(10L).orElse(null)
        );

        List<Medicine> medicine6 = Arrays.asList(
            medicineRepository.findById(11L).orElse(null),
            medicineRepository.findById(12L).orElse(null)
        );

        List<Medicine> medicine7 = Arrays.asList(
            medicineRepository.findById(13L).orElse(null),
            medicineRepository.findById(14L).orElse(null)
        );

        List<Medicine> medicine8 = Arrays.asList(
            medicineRepository.findById(15L).orElse(null),
            medicineRepository.findById(16L).orElse(null)
        );

        List<Medicine> medicine9 = Arrays.asList(
            medicineRepository.findById(17L).orElse(null),
            medicineRepository.findById(18L).orElse(null)
        );

        List<Medicine> medicine10 = Arrays.asList(
            medicineRepository.findById(19L).orElse(null),
            medicineRepository.findById(20L).orElse(null)
        );

        Vet vet1 = vetRepository.findById(1L).orElse(null);
        Vet vet2 = vetRepository.findById(2L).orElse(null);
        Vet vet3 = vetRepository.findById(3L).orElse(null);
        Vet vet4 = vetRepository.findById(4L).orElse(null);
        Vet vet5 = vetRepository.findById(5L).orElse(null);

        Pet pet1 = petRepository.findById(1L).orElse(null);

        // String name, List<Medicine> medicines, String description, Vet vet
        treatmentRepository.save(new Treatment("Tratamiento de fiebre", medicine1, "Reduce la fiebre en pacientes", vet1, pet1 ) );
        treatmentRepository.save(new Treatment("Tratamiento de infección", medicine2, "Antibiótico para infecciones", vet2, petRepository.findById(2L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento de alergias", medicine3, "Alivia los síntomas de alergias", vet3, petRepository.findById(3L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento de diabetes", medicine4, "Control diario para diabetes", vet4, petRepository.findById(4L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento para resfriado", medicine5, "Reduce los síntomas del resfriado", vet5, petRepository.findById(5L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento de dolor", medicine6, "Alivio para dolor leve", vet1,petRepository.findById(6L).get()) );
        treatmentRepository.save(new Treatment("Tratamiento de inflamación", medicine7, "Reduce la inflamación", vet2, petRepository.findById(7L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento para el control de glucosa", medicine8, "Control de glucosa en sangre", vet3, petRepository.findById(8L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento combinado", medicine9, "Controla la diabetes y alergias", vet4, petRepository.findById(9L).get() ) );
        treatmentRepository.save(new Treatment("Tratamiento para úlceras", medicine10, "Reduce la acidez estomacal", vet5, petRepository.findById(10L).get() ) );
    }

}
