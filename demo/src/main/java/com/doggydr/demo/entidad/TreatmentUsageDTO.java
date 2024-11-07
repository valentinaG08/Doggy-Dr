package com.doggydr.demo.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TreatmentUsageDTO {
    
    private Long treatmentId;
    private Long numUses;

}
