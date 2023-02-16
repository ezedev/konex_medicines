package com.konex.demo.domain.service;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;

@FunctionalInterface
public interface UpdateMedicine {

  public MedicineResponse execute(MedicineRequest medicineRequest, MedicineResponse medicineResponse);
}
