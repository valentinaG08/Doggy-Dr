package com.doggydr.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.MedicineRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.TreatmentRepository;
import com.doggydr.demo.repositorio.VetRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TreatmentRepositoryTest {
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @BeforeEach
    void init() {
        // Pets
        petRepository.save(new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", true));
        petRepository.save(new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", true));
        petRepository.save(new Pet("Zeus", "Golden Retriever", 2, "Displasia de cadera", 7.4, "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg", true));
         

        // Vets
        vetRepository.save(new Vet("Daniel Carvajal", "General", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "daniC", 10131415L, 310123123, "daniel@gmail.com", "passDaniel", true));
        vetRepository.save(new Vet("Valentina Garcia", "Cirugía", "https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias.jpg", "valeG", 20212223L, 310321321, "valentina@gmail.com", "passValentina", false));
        vetRepository.save(new Vet("Santiago Martínez", "Dermatología", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "santiM", 30312234L, 310456789, "santiago@gmail.com", "passSantiago", true));
        

        // Medicinas
        medicineRepository.save(new Medicine("Paracetamol", 100, 50, 0.50, 1.00));
        medicineRepository.save(new Medicine("Ibuprofeno", 200, 120, 0.30, 0.80));
        medicineRepository.save(new Medicine("Amoxicilina", 150, 80, 0.70, 1.50));
        medicineRepository.save(new Medicine("Aspirina", 300, 150, 0.25, 0.75));

        // Tratamientos
        List<Medicine> medicine1 = Arrays.asList(
            medicineRepository.findById(1L).orElse(null),
            medicineRepository.findById(2L).orElse(null)
        );
        
        List<Medicine> medicine2 = Arrays.asList(
            medicineRepository.findById(3L).orElse(null),
            medicineRepository.findById(4L).orElse(null)
        );
        
        List<Medicine> medicine3 = Arrays.asList(
            medicineRepository.findById(1L).orElse(null),
            medicineRepository.findById(2L).orElse(null)
        );
        List<Medicine> medicine4 = Arrays.asList(
            medicineRepository.findById(3L).orElse(null),
            medicineRepository.findById(4L).orElse(null)
        );
        Vet vet1 = vetRepository.findById(1L).orElse(null);
        Vet vet2 = vetRepository.findById(2L).orElse(null);
        Vet vet3 = vetRepository.findById(3L).orElse(null);

        Pet pet1 = petRepository.findById(1L).orElse(null);
        Pet pet2 = petRepository.findById(2L).orElse(null);
        Pet pet3 = petRepository.findById(3L).orElse(null);

        treatmentRepository.save(new Treatment("Tratamiento de fiebre", medicine1, "Reduce la fiebre en pacientes", vet1, pet1 ) );
        treatmentRepository.save(new Treatment("Tratamiento de infección", medicine2, "Antibiótico para infecciones", vet2,  pet2 ) );
        treatmentRepository.save(new Treatment("Tratamiento de alergias", medicine3, "Alivia los síntomas de alergias", vet3, pet3) );
        treatmentRepository.save(new Treatment("Tratamiento de diabetes", medicine4, "Control diario para diabetes", vet1,  pet3 ) );
        
        // asignar tratamientos a los pet
        pet1.setTreatments(  Arrays.asList(treatmentRepository.findById(1L).get(), treatmentRepository.findById(2L).get()) );
        pet2.setTreatments(  Arrays.asList(treatmentRepository.findById(2L).get(), treatmentRepository.findById(3L).get()) );
        pet3.setTreatments(  Arrays.asList(treatmentRepository.findById(3L).get(), treatmentRepository.findById(4L).get()) );
        
    }

    /*
     * @Query("SELECT p FROM Pet p JOIN p.treatments t WHERE t.id = :treatmentId")
     * List<Pet> findPetsById(@Param("treatmentId") Long treatmentId);
     */
    @Test
    public void TreatmentRepository_findPetsById_PetsList() {
        Long id = 2l;

        List<Pet> pets = treatmentRepository.findPetsById(id);

        // assert
        Assertions.assertThat(pets).isNotNull();
        Assertions.assertThat(pets.size()).isEqualTo(2);
        Assertions.assertThat(pets.size()).isGreaterThan(0);
    }

    /*
     * @Query("SELECT m FROM Medicine m JOIN m.treatments t WHERE t.id = :treatmentId")
     * List<Medicine> findMedicinesById(@Param("treatmentId") Long treatmentId);
     */
    @Test
    public void TreatmentRepository_findMedicinesById_MedicinesList() {
        Long id = 1l;

        List<Medicine> medicines = treatmentRepository.findMedicinesById(id);

        // assert
        Assertions.assertThat(medicines).isNotNull();
        Assertions.assertThat(medicines.size()).isEqualTo(2);
        Assertions.assertThat(medicines.size()).isGreaterThan(0);
    }

}
