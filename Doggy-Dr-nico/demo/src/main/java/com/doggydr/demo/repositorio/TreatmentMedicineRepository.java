package com.doggydr.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doggydr.demo.entidad.Pet;
import com.doggydr.demo.entidad.Treatment;
import com.doggydr.demo.entidad.TreatmentMedicine;

@Repository
public interface TreatmentMedicineRepository extends JpaRepository<TreatmentMedicine, Long> {

    long count();

    @Query(value = "SELECT MEDICINE_ID, COUNT(*) AS num_uses " +
            "FROM TREATMENT_MEDICINE " +
            "GROUP BY MEDICINE_ID " +
            "ORDER BY num_uses DESC", nativeQuery = true)
    List<Object[]> findTopMedicines();

    long findMedicineIdByTreatmentId(long Treatment_id);

    @Query(value = "SELECT SUM(m.SOLD_UNITS * m.SALES_PRICE) AS total_sales " +
            "FROM TREATMENT_MEDICINE tm " +
            "JOIN MEDICINE m ON tm.MEDICINE_ID = m.ID", nativeQuery = true)
    Long findTotalSales();

    @Query(value = "SELECT SUM((m.SALES_PRICE * m.SOLD_UNITS) - (m.COST * m.SOLD_UNITS)) AS total_gains " +
            "FROM MEDICINE m", nativeQuery = true)
    Long findTotalGains();
}
