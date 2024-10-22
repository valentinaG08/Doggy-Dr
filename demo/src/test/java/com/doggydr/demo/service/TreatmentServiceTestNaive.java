package com.doggydr.demo.service;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.MedicineRepository;
import com.doggydr.demo.repositorio.PetRepository;
import com.doggydr.demo.repositorio.VetRepository;
import com.doggydr.demo.servicio.TreatmentService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TreatmentServiceTestNaive {

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    public void TreatmentService_createTreatment_Treatment() {
        
        Treatment treatment = new Treatment("Tratamiento de fiebre",
                Arrays.asList(medicineRepository.findById(1l).get(), medicineRepository.findById(2l).get()),
                "Reduce la fiebre en pacientes", vetRepository.findById(1l).get(),
                Arrays.asList(petRepository.findById(1l).get(), petRepository.findById(1l).get()));

        Treatment newTreatment = treatmentService.add(treatment);

        Assertions.assertThat(newTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_findAll_TreatmentList() {

        List<Treatment> treatments = treatmentService.SearchAll();
        
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(10);
    }

}
