package com.konex.demo.domain.useCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.GetMedicineById;
import com.konex.demo.infrastructure.Info;
import com.konex.demo.infrastructure.entity.MedicineEntity;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import org.springframework.stereotype.Service;

@Service
public class GetMedicineByIdUseCase implements GetMedicineById {

  @Override
  public MedicineResponse execute(Long id) {

    //reemplazo de repository
    List<MedicineEntity> dbMedicines = Info.getSingletonInstance().getInfo();

    var result = dbMedicines.stream()
        .filter(m -> m.getId() == id)
        .findFirst()
        .orElse(null);

    return MedicineMapper
        .toResponse(result);
  }
  
}
