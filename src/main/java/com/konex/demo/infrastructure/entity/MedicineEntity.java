package com.konex.demo.infrastructure.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Table
@Entity

@Data
public class MedicineEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String factoryLaboratory;

  @Column
  private String creationDate;

  @Column
  private String dueDate;

  @Column
  private Integer stock;

  @Column
  private BigDecimal UnitValue;
}
