package com.konex.demo.application.useCases;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.useCase.UpdateMedicineUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class UpdateMedicineUseCaseTest {

  @InjectMocks
  UpdateMedicineUseCase updateMedicineUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void given_request_to_update_is_null() {

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

    var result = updateMedicineUseCase.execute(request, response);

    assertNull(result);

  }

}
