package com.konex.demo.application.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class MedicineRequest {

  private Long id;

  private String name;

  private String factoryLaboratory;

  private String creationDate;

  private String dueDate;

  private Integer stock;

  private BigDecimal UnitValue;
}
