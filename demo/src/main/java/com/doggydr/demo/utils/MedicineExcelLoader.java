package com.doggydr.demo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.doggydr.demo.entidad.Medicine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicineExcelLoader {

    // Método para leer el archivo Excel y cargar medicinas
    public List<Medicine> readMedicinesFromExcel(String filePath) {
        List<Medicine> medicines = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis)) {

            // Obtener la primera hoja del archivo Excel
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre cada fila de la hoja, comenzando en la fila 1 para saltar la
            // cabecera
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);

                // Leer cada columna y asignar los valores correspondientes
                String name = row.getCell(0).getStringCellValue();
                Double salePrice = row.getCell(1).getNumericCellValue();
                Double purchasePrice = row.getCell(2).getNumericCellValue();
                int unitsAvailable = (int) row.getCell(3).getNumericCellValue();
                int unitsSold = (int) row.getCell(4).getNumericCellValue();

                // Crear una instancia de Medicine y añadirla a la lista
                // Medicine(String name, int availableUnits, int soldUnits, Double cost, Double
                // salesPrice)
                Medicine medicine = new Medicine().builder().name(name).availableUnits(unitsAvailable)
                        .soldUnits(unitsSold).cost(purchasePrice).salesPrice(salePrice).build();

                medicines.add(medicine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicines;
    }
}
