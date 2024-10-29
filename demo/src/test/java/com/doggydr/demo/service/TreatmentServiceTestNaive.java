package com.doggydr.demo.service;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.MedicineRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.TreatmentRepository;
import com.doggydr.demo.repositorio.VetRepository;
import com.doggydr.demo.servicio.TreatmentService;

import jakarta.transaction.Transactional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TreatmentServiceTestNaive {

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private MedicineRepository medicineRepository;

   @BeforeEach
    void init() {
        // Pets
        petRepository.save(new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", true));
        petRepository.save(new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", true));
        
        // Vets
        vetRepository.save(new Vet("Daniel Carvajal", "General", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "daniC", 10131415L, 310123123, "daniel@gmail.com", "passDaniel", true));
        
        // Medicinas
        medicineRepository.save(new Medicine("Paracetamol", 100, 50, 0.50, 1.00));
        medicineRepository.save(new Medicine("Ibuprofeno", 200, 120, 0.30, 0.80));
        medicineRepository.save(new Medicine("Amoxicilina", 150, 80, 0.70, 1.50));
        medicineRepository.save(new Medicine("Aspirina", 300, 150, 0.25, 0.75));

        // Tratamientos
        List<Medicine> medicine1 = medicineRepository.findAllById(Arrays.asList(1L, 2L));

        System.out.println(" \nmed1: " + medicine1.size());

        Vet vet1 = vetRepository.findById(1L).orElse(null);
        
        Pet pet1 = petRepository.findById(1L).orElse(null);
        Pet pet2 = petRepository.findById(2L).orElse(null);
        
        treatmentService.add(new Treatment("Tratamiento de fiebre", medicine1, "Reduce la fiebre en pacientes", vet1, pet1 ) );
        

        /*
        treatmentService.add(new Treatment("Tratamiento de infección", medicine1, "Antibiótico para infecciones", vet2,  Arrays.asList( pet2, pet3 ) ) );
        treatmentService.add(new Treatment("Tratamiento de alergias", medicine1, "Alivia los síntomas de alergias", vet3, Arrays.asList(pet3, pet1 ) ) );
        treatmentService.add(new Treatment("Tratamiento de diabetes", medicine1, "Control diario para diabetes", vet1,  Arrays.asList(pet3, pet2 ) ) );
        
        // asignar tratamientos a los pet
        pet1.setTreatments(  Arrays.asList(treatmentService.SearchById(1L), treatmentService.SearchById(2L)) );
        pet2.setTreatments(  Arrays.asList(treatmentService.SearchById(2L), treatmentService.SearchById(3L)) );
        pet3.setTreatments(  Arrays.asList(treatmentService.SearchById(3L), treatmentService.SearchById(4L)) );
        */
        
    }


    @Test
    public void TreatmentService_add_Treatment() {
        
        System.out.println("\n\n tr med1:" + medicineRepository.findById(1l).get().getId());
        System.out.println("\n\n tr med2:" + medicineRepository.findById(2l).get().getId());
        System.out.println("\n tr vet:" + vetRepository.findById(1l).get().getId());
        System.out.println("\n tr pet1:" + petRepository.findById(1l).get().getId());
        System.out.println("\n tr pet2:" + petRepository.findById(2l).get().getId());

        Treatment treatment = new Treatment("Tratamiento de fiebre",
                Arrays.asList(medicineRepository.findById(1l).get(), medicineRepository.findById(2l).get()),
                "Reduce la fiebre en pacientes", vetRepository.findById(1l).get(),
                petRepository.findById(1l).get());

        System.out.println("\n\n tr med:" + treatment.getMedicines().size());

        Treatment newTreatment = treatmentService.add(treatment);

        Assertions.assertThat(newTreatment).isNotNull();
    }


    @Test
    public void TreatmentService_SearchAll_TreatmentList() {

        List<Treatment> treatments = treatmentService.SearchAll();
        
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(1);
    }

    @Test
    public void TreatmentService_SearchById_Treatment() {

        Treatment treatment = treatmentService.SearchById(1l);
        
        Assertions.assertThat(treatment).isNotNull();
    }

}
