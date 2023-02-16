package com.konex.demo.application.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.konex.demo.domain.useCase.GetMedicineByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class GetMedicineByIdUseCaseTest {

  @InjectMocks
  GetMedicineByIdUseCase getMedicineByIdUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void give_id_to_get_byId() {

    var result = getMedicineByIdUseCase.execute(1l);

    assertNotNull(result);
    assertEquals(2, result.getStock());

  }
}
