package com.konex.demo.domain.useCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.repository.MedicineRepository;
import com.konex.demo.infrastructure.entity.MedicineEntity;
import com.konex.demo.domain.service.GetAllMedicines;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllMedicinesUseCase implements GetAllMedicines {


  @Autowired
  private MedicineRepository medicineRepository;

  @Override
  public List<MedicineResponse> execute() {

    //reemplazo de repository
    List<MedicineEntity> dbMedicines = getHarcodedMedicines();

    return dbMedicines.stream().map(MedicineMapper::toResponse).collect(Collectors.toList());
  }

  private List<MedicineEntity> getHarcodedMedicines() {
    var medicines = new ArrayList<MedicineEntity>();

    var med1 = new MedicineEntity();
    med1.setId(1L);
    med1.setName("medicina hardcodeada 1");
    med1.setStock(2);
    med1.setCreationDate("22-01-21");
    med1.setDueDate("22-01-2025");
    med1.setFactoryLaboratory("laboratorio bogota");
    med1.setUnitValue(BigDecimal.valueOf(1.05));

    var med2 = new MedicineEntity();
    med2.setId(2L);
    med2.setName("medicina hardcodeada 2");
    med2.setStock(2);
    med2.setCreationDate("22-01-21");
    med2.setDueDate("22-01-2025");
    med2.setFactoryLaboratory("laboratorio Medellin");
    med2.setUnitValue(BigDecimal.valueOf(1.05));

    var med3 = new MedicineEntity();
    med3.setId(3L);
    med3.setName("medicina hardcodeada 3");
    med3.setStock(2);
    med3.setCreationDate("22-01-21");
    med3.setDueDate("22-01-2025");
    med3.setFactoryLaboratory("laboratorio Cartagena");
    med3.setUnitValue(BigDecimal.valueOf(1.05));

    medicines.add(med1);
    medicines.add(med2);
    medicines.add(med3);

    return medicines;

  }

}
