package com.konex.demo.domain.useCase;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.CreateNewMedicine;
import org.springframework.stereotype.Service;

@Service
public class CreateNewMedicineUseCase implements CreateNewMedicine {

  @Override
  public MedicineResponse execute(MedicineRequest medicineRequest) {
    return null;
  }
}
