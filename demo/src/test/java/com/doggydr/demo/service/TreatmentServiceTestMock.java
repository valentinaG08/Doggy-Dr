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
                    new Pet("Perry", "French Poodle", 2, "Otitis", 3.4, "https://wowmascota.com/wp-content/uploads/2019/05/pets-753464_640.jpg"), 
                    new Pet("Lucas", "Labrador", 2, "Gastroenteritis", 6.1, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/ThinkstockPhotos-590080440.jpg?w=1024")));

        System.out.println("\n\n tr med:" + treatment.getMedicines().size());

        when(treatmentRepository.save(treatment)).thenReturn(
            treatment
        );

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
