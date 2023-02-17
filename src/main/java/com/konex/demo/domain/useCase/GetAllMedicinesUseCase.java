package com.konex.demo.domain.useCase;

import java.util.List;
import java.util.stream.Collectors;

import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.infrastructure.Info;
import com.konex.demo.infrastructure.entity.MedicineEntity;
import com.konex.demo.domain.service.GetAllMedicines;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAllMedicinesUseCase implements GetAllMedicines {

  @Override
  public List<MedicineResponse> execute() {

    //reemplazo de repository
    List<MedicineEntity> dbMedicines = Info.getSingletonInstance().getInfo();

    return dbMedicines.stream().map(MedicineMapper::toResponse).collect(Collectors.toList());
  }

}
