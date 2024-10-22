package com.doggydr.demo.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
import com.doggydr.demo.servicio.TreatmentServiceImpl;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TreatmentServiceTestMock {

    @InjectMocks
    private TreatmentServiceImpl treatmentService;

    @Mock
    TreatmentRepository treatmentRepository;


    @Mock
    private PetRepository petRepository;

    @Mock
    private VetRepository vetRepository;

    @Mock
    private MedicineRepository medicineRepository;

    @BeforeEach
    void init() {
        
    }


    @Test
    public void TreatmentService_add_Treatment() {
    
        Treatment treatment = new Treatment("Tratamiento de fiebre",
                Arrays.asList(
                    new Medicine("Paracetamol", 100, 50, 0.50, 1.00), 
                    new Medicine("Ibuprofeno", 200, 120, 0.30, 0.80)),
                "Reduce la fiebre en pacientes", 
                new Vet("Daniel Carvajal", "General", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "daniC", 10131415L, 310123123, "daniel@gmail.com", "passDaniel", true),
                Arrays.asList(
                    new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", true), 
                    new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", true)));

        System.out.println("\n\n tr med:" + treatment.getMedicines().size());

        when(treatmentRepository.save(treatment)).thenReturn(
            treatment
        );

        Treatment newTreatment = treatmentService.add(treatment);

        Assertions.assertThat(newTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_SearchAll_TreatmentList() {

        when(treatmentRepository.findAll()).thenReturn(
            List.of(
                new Treatment("Tratamiento de fiebre",
                    Arrays.asList(
                        new Medicine("Paracetamol", 100, 50, 0.50, 1.00), 
                        new Medicine("Ibuprofeno", 200, 120, 0.30, 0.80)),
                    "Reduce la fiebre en pacientes", 
                    new Vet("Daniel Carvajal", "General", "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.original.jpg", "daniC", 10131415L, 310123123, "daniel@gmail.com", "passDaniel", true),
                    Arrays.asList(
                        new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg", true), 
                        new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024", true))
                ),
                new Treatment("Tratamiento de alergia",
                    Arrays.asList(
                        new Medicine("Cetirizina", 150, 75, 0.40, 0.90), 
                        new Medicine("Clorfenamina", 50, 30, 0.20, 0.60)),
                    "Alivia los síntomas de la alergia en mascotas",
                    new Vet("Carla Gómez", "Especialista en Dermatología", "https://veterinariaintegral.es/wp-content/uploads/2020/01/veterinaria.jpg", "carlaG", 10131678L, 310456789, "carla@gmail.com", "passCarla", true),
                    Arrays.asList(
                        new Pet("Max", "Golden Retriever", 5, "Dermatitis", 29.0, "https://cdn.pixabay.com/photo/2017/09/25/13/12/golden-retriever-2785074_960_720.jpg", true),
                        new Pet("Milo", "Beagle", 4, "Alergia alimentaria", 12.5, "https://cdn.pixabay.com/photo/2016/02/18/22/16/beagle-1207805_960_720.jpg", true))
                )
            )
        );

        List<Treatment> treatments = treatmentService.SearchAll();
        
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(2);
    }

    @Test
    public void TreatmentService_SearchById_Treatment() {

        /*when(treatmentRepository.findById(1l)).thenReturn(
            treatment
        )*/

        Treatment treatment = treatmentService.SearchById(1l);
        
        Assertions.assertThat(treatment).isNotNull();
    }

}
