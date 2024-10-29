package com.doggydr.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.doggydr.demo.controlador.TreatmentController;
import com.doggydr.demo.entidad.Medicine;
import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentUsageDTO;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.servicio.PetService;
import com.doggydr.demo.servicio.TreatmentService;
import com.doggydr.demo.servicio.VetService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = TreatmentController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TreatmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @MockBean
    private TreatmentService treatmentService;

    @MockBean
    private VetService vetService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void TreatmentController_showTreatments_AllTreatments() throws Exception {

        when(treatmentService.SearchAll()).thenReturn(
                List.of(
                        new Treatment(
                                "Tratamiento 1",
                                new ArrayList<>(),
                                "Descripción del tratamiento 1",
                                new Vet(),
                                new Pet()),
                        new Treatment(
                                "Tratamiento 2",
                                new ArrayList<>(),
                                "Descripción del tratamiento 2",
                                new Vet(),
                                new Pet())));

        ResultActions response = mockMvc.perform(get("/treatment/all")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk()) // estado HTTP OK
                .andExpect(jsonPath("$.size()").value(2)) // tamaño de la lista es correcto
                .andExpect(jsonPath("$[0].name").value("Tratamiento 1"))
                .andExpect(jsonPath("$[1].name").value("Tratamiento 2"));
    }

    @Test
    public void TreatmentController_showTreatments_Id_NotFound() throws Exception {

        when(treatmentService.SearchById(anyLong())).thenReturn(
                null);

        ResultActions response = mockMvc.perform(
                get("/treatment/").param("id", "1"));

        response.andExpect(status().isNotFound());

    }

    @Test
    public void TreatmentController_showTreatments_Id_Success() throws Exception {

        Long treatmentId = 1L;

        Treatment treatment = new Treatment(
                "Tratamiento 1",
                new ArrayList<>(),
                "Descripción del tratamiento",
                new Vet(),
                new Pet());

        when(treatmentService.SearchById(treatmentId)).thenReturn(treatment);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Tratamiento 1"))
                .andExpect(jsonPath("$.description").value("Descripción del tratamiento"));
    }

    @Test
    public void TreatmentController_showTrearmentTreatments_Success() throws Exception {
        Long treatmentId = 1L;

        List<Pet> pets = List.of(new Pet(), new Pet());

        Mockito.when(treatmentService.SearchPetsById(treatmentId)).thenReturn(pets);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/pets", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk()) // estado HTTP OK
                .andExpect(jsonPath("$.size()").value(pets.size()));
    }

    @Test
    public void TreatmentController_showTrearmentTreatments_NotFound() throws Exception {

        Long treatmentId = 1L;

        Mockito.when(treatmentService.SearchPetsById(treatmentId)).thenReturn(null);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/pets", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_showTrearmentMedicines_Success() throws Exception {
        Long treatmentId = 1L;

        List<Medicine> medicines = List.of(new Medicine(), new Medicine());

        Mockito.when(treatmentService.SearchMedicinesById(treatmentId)).thenReturn(medicines);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/medicines", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk()) // estado HTTP OK
                .andExpect(jsonPath("$.size()").value(medicines.size())); // Verifica que el tamaño de la lista de
                                                                          // medicinas sea correcto
    }

    @Test
    public void TreatmentController_showTrearmentMedicines_NotFound() throws Exception {
        Long treatmentId = 1L;

        Mockito.when(treatmentService.SearchMedicinesById(treatmentId)).thenReturn(null);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/medicines", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_addTreatment_Treatment() throws Exception {

        List<Medicine> medicines = new ArrayList<>();
        medicines.add(new Medicine());
        Vet vet = new Vet();
        Pet pet = new Pet();

        Treatment treatment = new Treatment("Tratamiento 1", medicines, "Descripción del tratamiento", vet, pet);

        when(treatmentService.add(Mockito.any(Treatment.class))).thenReturn(treatment);

        ResultActions response = mockMvc.perform(
                post("/treatment/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(treatment)));

        // Convierte el objeto a JSON
        response.andExpect(status().isCreated()) // Estado HTTP Created
                .andExpect(jsonPath("$.name").value("Tratamiento 1"))
                .andExpect(jsonPath("$.description").value("Descripción del tratamiento"));
    }

    @Test
    public void TreatmentController_deleteTreatment_Id_Exito() throws Exception {

        Long treatmentId = 1L;

        Mockito.doNothing().when(treatmentService).DeleteById(treatmentId);

        ResultActions response = mockMvc.perform(
                delete("/treatment/delete/{id}", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNoContent());
    }

    @Test
    public void TreatmentController_showPetOwner_Success() throws Exception {
        Long treatmentId = 1L;

        Vet vet = new Vet();
        vet.setId(1L);

        Treatment treatment = new Treatment();
        treatment.setVet(vet);

        Mockito.when(treatmentService.SearchById(treatmentId)).thenReturn(treatment);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/vet", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk()) // estado HTTP OK
                .andExpect(jsonPath("$.id").value(vet.getId())); // Verifica que el ID del veterinario sea correcto
    }

    @Test
    public void TreatmentController_showPetOwner_TreatmentNotFound() throws Exception {
        Long treatmentId = 1L;

        Mockito.when(treatmentService.SearchById(treatmentId)).thenReturn(null);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/vet", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_showPetOwner_VetNotFound() throws Exception {
        Long treatmentId = 1L;

        Treatment treatment = new Treatment();
        treatment.setVet(null);

        Mockito.when(treatmentService.SearchById(treatmentId)).thenReturn(treatment);

        ResultActions response = mockMvc.perform(
                get("/treatment/{id}/vet", treatmentId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_associateTreatmentWithVet_Success() throws Exception {
        Long treatmentId = 1L;
        Long vetId = 1L;

        Vet vet = new Vet();
        vet.setId(vetId);
        vet.setName("Dr. John Doe");

        Treatment treatment = new Treatment();
        treatment.setId(treatmentId);
        treatment.setName("Tratamiento 1");
        treatment.setVet(vet);

        Mockito.when(vetService.SearchById(vetId)).thenReturn(vet);
        Mockito.when(treatmentService.SearchById(treatmentId)).thenReturn(treatment);

        Mockito.doNothing().when(treatmentService).update(treatment);

        ResultActions response = mockMvc.perform(
                put("/treatment/{treatmentId}/associate/{vetId}", treatmentId, vetId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Tratamiento 1"))
                // No verificamos el campo vet debido a @JsonIgnore
                .andExpect(jsonPath("$.vet").doesNotExist());
    }

    @Test
    public void TreatmentController_associateTreatmentWithVet_VetNotFound() throws Exception {
        Long treatmentId = 1L;
        Long vetId = 1L;

        Mockito.when(vetService.SearchById(vetId)).thenReturn(null);

        ResultActions response = mockMvc.perform(
                put("/treatment/{treatmentId}/associate/{vetId}", treatmentId, vetId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_associateTreatmentWithVet_TreatmentNotFound() throws Exception {
        Long treatmentId = 1L;
        Long vetId = 1L;

        Vet vet = new Vet();
        vet.setId(vetId);

        Mockito.when(vetService.SearchById(vetId)).thenReturn(vet);

        Mockito.when(treatmentService.SearchById(treatmentId)).thenReturn(null);

        ResultActions response = mockMvc.perform(
                put("/treatment/{treatmentId}/associate/{vetId}", treatmentId, vetId)
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void TreatmentController_getTotalTreatments_Success() throws Exception {
        long totalTreatments = 10L;

        Mockito.when(treatmentService.getTotalTreatments()).thenReturn(totalTreatments);

        ResultActions response = mockMvc.perform(
                get("/treatment/total")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$").value(totalTreatments)); // Verifica el total de tratamientos
    }

    @Test
    public void TreatmentController_getTop3_Success() throws Exception {
        List<TreatmentUsageDTO> topTreatments = List.of(
                new TreatmentUsageDTO(1L, 100L),
                new TreatmentUsageDTO(2L, 80L),
                new TreatmentUsageDTO(3L, 60L));

        Mockito.when(treatmentService.findTop3Treatments()).thenReturn(topTreatments);

        ResultActions response = mockMvc.perform(
                get("/treatment/top3")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(topTreatments.size())) // Verifica que se devuelven 3 tratamientos
                .andExpect(jsonPath("$[0].treatmentId").value(1L))
                .andExpect(jsonPath("$[0].numUses").value(100L))
                .andExpect(jsonPath("$[1].treatmentId").value(2L))
                .andExpect(jsonPath("$[1].numUses").value(80L))
                .andExpect(jsonPath("$[2].treatmentId").value(3L))
                .andExpect(jsonPath("$[2].numUses").value(60L));
    }

    @Test
    public void TreatmentController_getTreatmentsByMedicine_Success() throws Exception {

        List<TreatmentUsageDTO> treatmentsByMedicine = List.of(
                new TreatmentUsageDTO(1L, 120L),
                new TreatmentUsageDTO(2L, 90L));

        Mockito.when(treatmentService.findTopMedicines()).thenReturn(treatmentsByMedicine);

        ResultActions response = mockMvc.perform(
                get("/treatment/Medicines")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(treatmentsByMedicine.size())) // Verifica el número de
                                                                                    // tratamientos por medicina
                .andExpect(jsonPath("$[0].treatmentId").value(1L))
                .andExpect(jsonPath("$[0].numUses").value(120L))
                .andExpect(jsonPath("$[1].treatmentId").value(2L))
                .andExpect(jsonPath("$[1].numUses").value(90L));
    }

    @Test
    public void TreatmentController_getTotalSales_Success() throws Exception {
        long totalSales = 5000L;

        Mockito.when(treatmentService.getTotalSales()).thenReturn(totalSales);

        ResultActions response = mockMvc.perform(
                get("/treatment/totalSales")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$").value(totalSales));
    }

    @Test
    public void TreatmentController_getTotalGains_Success() throws Exception {
        long totalGains = 10000L;

        Mockito.when(treatmentService.getTotalGains()).thenReturn(totalGains);

        ResultActions response = mockMvc.perform(
                get("/treatment/totalGains")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$").value(totalGains));
    }

}