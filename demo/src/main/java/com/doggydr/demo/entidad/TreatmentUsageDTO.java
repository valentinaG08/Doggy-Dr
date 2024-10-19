package com.doggydr.demo.entidad;

public class TreatmentUsageDTO {
    private Long treatmentId;
    private Long numUses;

    public TreatmentUsageDTO(Long treatmentId, Long numUses) {
        this.treatmentId = treatmentId;
        this.numUses = numUses;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Long getNumUses() {
        return numUses;
    }

    public void setNumUses(Long numUses) {
        this.numUses = numUses;
    }
}
