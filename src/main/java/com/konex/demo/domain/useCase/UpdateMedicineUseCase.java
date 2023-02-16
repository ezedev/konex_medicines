package com.konex.demo.domain.useCase;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.UpdateMedicine;
import org.springframework.stereotype.Service;

@Service
public class UpdateMedicineUseCase implements UpdateMedicine {

  @Override
  public MedicineResponse execute(MedicineRequest medicineRequest, MedicineResponse medicineResponse) {
    return null;
  }
}
