package com.konex.demo.application.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class MedicineResponse {

  private Long id;

  private String name;

  private String factoryLaboratory;

  private String creationDate;

  private String dueDate;

  private Integer stock;

  private BigDecimal UnitValue;
}
