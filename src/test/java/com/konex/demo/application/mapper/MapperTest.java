package com.konex.demo.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import org.junit.jupiter.api.Test;

public class MapperTest {

  @Test
  public void given_request_to_response() {

    var request = new MedicineRequest();
    request.setId(1L);
    request.setUnitValue(BigDecimal.valueOf(2.2));
    request.setStock(2);
    request.setFactoryLaboratory("laboratorio de Bogota");

    var result = MedicineMapper.toResponse(request);
    assertEquals(request.getId(), result.getId());
    assertEquals(request.getUnitValue(), result.getUnitValue());
    assertEquals(request.getFactoryLaboratory(), result.getFactoryLaboratory());

  }

  @Test
  public void given_response_to_request() {

    var response = MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .factoryLaboratory("laboratorio test 1")
        .build();

    var result = MedicineMapper.toRequest(response);
    assertEquals(response.getId(), result.getId());
    assertEquals(response.getUnitValue(), result.getUnitValue());
    assertEquals(response.getFactoryLaboratory(), result.getFactoryLaboratory());

  }

  @Test
  public void given_response_to_entity() {

    var response = MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .dueDate("fecha")
        .factoryLaboratory("laboratorio test 1")
        .build();

    var result = MedicineMapper.toEntity(response);
    assertEquals(response.getId(), result.getId());
    assertEquals(response.getUnitValue(), result.getUnitValue());
    assertEquals(response.getFactoryLaboratory(), result.getFactoryLaboratory());

  }


}
