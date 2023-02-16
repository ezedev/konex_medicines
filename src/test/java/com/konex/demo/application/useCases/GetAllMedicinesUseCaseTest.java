package com.konex.demo.application.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.konex.demo.domain.useCase.GetAllMedicinesUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class GetAllMedicinesUseCaseTest {

  @InjectMocks
  GetAllMedicinesUseCase getAllMedicinesUseCase;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void call_getAllMedicines_use_case() {

    var result = getAllMedicinesUseCase.execute();

    assertNotNull(result);
    assertEquals(3, result.size());

  }

}
