package com.konex.demo.domain.service;

import java.util.List;

import com.konex.demo.application.response.MedicineResponse;

@FunctionalInterface
public interface GetAllMedicines {
  public List<MedicineResponse> execute();
}
