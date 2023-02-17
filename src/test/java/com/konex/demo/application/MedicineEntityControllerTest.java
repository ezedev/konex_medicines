package com.konex.demo.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.konex.demo.application.api.MedicineController;
import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.CreateNewMedicine;
import com.konex.demo.domain.service.GetAllMedicines;
import com.konex.demo.domain.service.GetMedicineById;
import com.konex.demo.domain.service.UpdateMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

public class MedicineEntityControllerTest {

  @InjectMocks
  private MedicineController medicineController;

  @Mock
  private GetAllMedicines getAllMedicinesUseCase;

  @Mock
  private GetMedicineById getMedicineByIdUseCase;

  @Mock
  private UpdateMedicine updateMedicineUseCase;

  @Mock
  private CreateNewMedicine createNewMedicineUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void get_all_medicines() {

    var response = new ArrayList<MedicineResponse>();
    response.add(MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .factoryLaboratory("laboratorio test 1").build());
    response.add(MedicineResponse.builder()
        .id(2L)
        .stock(2)
        .factoryLaboratory("laboratorio test 2").build());

    response.add(MedicineResponse.builder()
        .id(3L)
        .stock(2)
        .factoryLaboratory("laboratorio test 3").build());

    Mockito.when(getAllMedicinesUseCase.execute()).thenReturn(response);

    var result = medicineController.getAllMedicines();

    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(3, result.getBody().size());

  }

  @Test
  public void get_by_id() {

    var response = MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .factoryLaboratory("laboratorio test 1")
        .build();

    Mockito.when(getMedicineByIdUseCase.execute(1L)).thenReturn(response);

    var result = medicineController.getById(1L);

    assertEquals(1L, result.getId());
    assertEquals(2, result.getStock());
  }

  @Test
  public void given_request_to_update_medicine() {

    var response = MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .dueDate("fecha")
        .factoryLaboratory("laboratorio test 1")
        .build();
    var request = new MedicineRequest();
    request.setId(1L);
    request.setUnitValue(BigDecimal.valueOf(2.2));
    request.setStock(2);
    request.setFactoryLaboratory("laboratorio de Bogota");

    Mockito.when(getMedicineByIdUseCase.execute(1L)).thenReturn(response);
    Mockito.when(updateMedicineUseCase.execute(request, response)).thenReturn(response);

    var result = medicineController.update(request, 1L);

    assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

  }

  @Test
  public void given_request_to_update_medicine_isEmpty() {
    var request = new MedicineRequest();
    request.setId(1L);
    request.setUnitValue(BigDecimal.valueOf(2.2));
    request.setStock(2);
    request.setFactoryLaboratory("laboratorio de Bogota");

    Mockito.when(getMedicineByIdUseCase.execute(1L)).thenReturn(null);

    var result = medicineController.update(request, 1L);

    assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

  }

  @Test
  public void given_request_to_create() {
    var response = MedicineResponse.builder()
        .id(1L)
        .stock(2)
        .factoryLaboratory("laboratorio test 1")
        .build();
    var request = new MedicineRequest();
    request.setId(1L);
    request.setUnitValue(BigDecimal.valueOf(2.2));
    request.setStock(2);
    request.setFactoryLaboratory("laboratorio de Bogota");

    Mockito.when(createNewMedicineUseCase.execute(request)).thenReturn(response);

    var result = medicineController.create(request);

    assertEquals(HttpStatus.CREATED, result.getStatusCode());

  }

}
