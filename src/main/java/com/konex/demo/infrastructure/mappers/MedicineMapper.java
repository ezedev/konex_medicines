package com.konex.demo.infrastructure.mappers;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.infrastructure.entity.MedicineEntity;

public class MedicineMapper {

  public static MedicineEntity toEntity(MedicineResponse source) {
    var entity = new MedicineEntity();
    entity.setDueDate(source.getDueDate());
    entity.setId(source.getId());
    entity.setUnitValue(source.getUnitValue());
    entity.setFactoryLaboratory(source.getFactoryLaboratory());
    entity.setStock(source.getStock());
    entity.setCreationDate(source.getCreationDate());
    return entity;
  }

  public static MedicineResponse toResponse(MedicineEntity target) {
    var response = new MedicineResponse();
    response.setDueDate(target.getDueDate());
    response.setId(target.getId());
    response.setUnitValue(target.getUnitValue());
    response.setFactoryLaboratory(target.getFactoryLaboratory());
    response.setStock(target.getStock());
    response.setCreationDate(target.getCreationDate());
    return response;
  }

  public static MedicineResponse toResponse(MedicineRequest target) {
    var response = new MedicineResponse();
    response.setDueDate(target.getDueDate());
    response.setId(target.getId());
    response.setUnitValue(target.getUnitValue());
    response.setFactoryLaboratory(target.getFactoryLaboratory());
    response.setStock(target.getStock());
    response.setCreationDate(target.getCreationDate());
    return response;
  }

  public static MedicineRequest toRequest(MedicineResponse source) {
    var request = new MedicineRequest();
    request.setDueDate(source.getDueDate());
    request.setId(source.getId());
    request.setUnitValue(source.getUnitValue());
    request.setFactoryLaboratory(source.getFactoryLaboratory());
    request.setStock(source.getStock());
    request.setCreationDate(source.getCreationDate());
    return request;
  }
}
