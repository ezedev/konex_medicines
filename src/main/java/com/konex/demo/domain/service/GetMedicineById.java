package com.konex.demo.domain.service;

import com.konex.demo.application.response.MedicineResponse;

@FunctionalInterface
public interface GetMedicineById {
  public MedicineResponse execute(Long id);

}
