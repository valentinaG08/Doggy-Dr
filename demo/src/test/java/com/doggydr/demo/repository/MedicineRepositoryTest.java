package com.doggydr.demo.repository;

import java.util.Arrays;
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
import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.MedicineRepository;
import com.doggydr.demo.repositorio.TreatmentRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MedicineRepositoryTest {
    
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @BeforeEach
    void init() {
        
        // Medicinas
        medicineRepository.save(new Medicine().builder().name("Paracetamol").availableUnits(100).soldUnits(50).cost(0.50).salesPrice(1.00).build());
        medicineRepository.save(new Medicine().builder().name("Ibuprofeno").availableUnits(200).soldUnits(120).cost(0.30).salesPrice(0.80).build());
        medicineRepository.save(new Medicine().builder().name("Amoxicilina").availableUnits(150).soldUnits(80).cost(0.70).salesPrice(1.50).build());
        medicineRepository.save(new Medicine().builder().name("Aspirina").availableUnits(300).soldUnits(150).cost(0.25).salesPrice(0.75).build());
    }

    @Test
    public void MedicineRepository_FindAll_NotEmpyList(){
        // act
        List<Medicine> medicines = medicineRepository.findAll();

        // assert
        Assertions.assertThat(medicines).isNotNull();
        Assertions.assertThat(medicines.size()).isEqualTo(4);
        Assertions.assertThat(medicines.size()).isGreaterThan(0);
    }

    @Test
    public void MedicineRepository_findById_Medicine() {
        Long index = 1l;

        Optional<Medicine> medicine = medicineRepository.findById(index);

        Assertions.assertThat(medicine).isNotEmpty();
    }
}
