package com.konex.demo.domain.useCase;

import java.math.BigDecimal;
import java.util.Random;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.CreateNewMedicine;
import com.konex.demo.infrastructure.Info;
import com.konex.demo.infrastructure.entity.MedicineEntity;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateNewMedicineUseCase implements CreateNewMedicine {

  @Override
  public MedicineResponse execute(MedicineRequest medicineRequest) {

    MedicineEntity med1 = createEntity(medicineRequest);
    Info.getSingletonInstance().getInfo().add(med1);
    return MedicineMapper.toResponse(medicineRequest);
  }

  private static MedicineEntity createEntity(MedicineRequest medicineRequest) {
    var med1 = new MedicineEntity();
    med1.setId((long) new Random().nextInt(150 + 1));
    med1.setName(medicineRequest.getName());
    med1.setStock(medicineRequest.getStock());
    med1.setCreationDate(medicineRequest.getCreationDate());
    med1.setDueDate(medicineRequest.getDueDate());
    med1.setFactoryLaboratory(medicineRequest.getFactoryLaboratory());
    med1.setUnitValue(medicineRequest.getUnitValue());
    return med1;
  }
}
