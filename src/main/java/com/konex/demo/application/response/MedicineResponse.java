package com.konex.demo.application.response;

import java.math.BigDecimal;

import javax.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class MedicineResponse {

  private Long id;

  private String name;

  private String factoryLaboratory;

  private String creationDate;

  private String dueDate;

  private Integer stock;

  private BigDecimal UnitValue;
}
