package com.konex.demo.application.useCases;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.domain.useCase.CreateNewMedicineUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CreateNewMedicineUseCaseTest {

  @InjectMocks
  CreateNewMedicineUseCase createNewMedicineUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void given_request_to_create() {

    var request = new MedicineRequest();
    request.setId(1L);
    request.setUnitValue(BigDecimal.valueOf(2.2));
    request.setStock(2);
    request.setFactoryLaboratory("laboratorio de Bogota");
    var result = createNewMedicineUseCase.execute(request);

    assertNull(result);

  }

}
