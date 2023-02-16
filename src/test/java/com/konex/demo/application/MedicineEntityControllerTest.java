package com.konex.demo.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.konex.demo.application.api.MedicineController;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.GetAllMedicines;
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
  GetAllMedicines getAllMedicinesUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }
  @Test
  public void get_all_medicines() {

    var response = new ArrayList<MedicineResponse>();


    Mockito.when(getAllMedicinesUseCase.execute()).thenReturn(response);

    var result = medicineController.getAllMedicines();

    assertEquals(HttpStatus.OK, result.getStatusCode());

  }

}
