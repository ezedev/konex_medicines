package com.konex.demo.infrastructure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.konex.demo.infrastructure.entity.MedicineEntity;

public class Info {

  private List<MedicineEntity> info;
  public static Info singleton;

  // El constructor es privado, no permite que se genere un constructor por defecto.
  private Info() {
    this.info = getHarcodedMedicines();
  }
  public static Info getSingletonInstance() {
    if (singleton == null){
      singleton = new Info();
    }
    else{
      System.out.println("ya Soy Unico");
    }

    return singleton;
  }

  public List<MedicineEntity> getInfo() {
    return info;
  }

  private List<MedicineEntity> getHarcodedMedicines() {
    var medicines = new ArrayList<MedicineEntity>();

    var med1 = new MedicineEntity();
    med1.setId(1L);
    med1.setName("medicina hardcodeada 1");
    med1.setStock(2);
    med1.setCreationDate("22-01-21");
    med1.setDueDate("22-01-2025");
    med1.setFactoryLaboratory("laboratorio bogota");
    med1.setUnitValue(BigDecimal.valueOf(1.05));

    var med2 = new MedicineEntity();
    med2.setId(2L);
    med2.setName("medicina hardcodeada 2");
    med2.setStock(2);
    med2.setCreationDate("22-01-21");
    med2.setDueDate("22-01-2025");
    med2.setFactoryLaboratory("laboratorio Medellin");
    med2.setUnitValue(BigDecimal.valueOf(1.05));

    var med3 = new MedicineEntity();
    med3.setId(3L);
    med3.setName("medicina hardcodeada 3");
    med3.setStock(2);
    med3.setCreationDate("22-01-21");
    med3.setDueDate("22-01-2025");
    med3.setFactoryLaboratory("laboratorio Cartagena");
    med3.setUnitValue(BigDecimal.valueOf(1.05));

    medicines.add(med1);
    medicines.add(med2);
    medicines.add(med3);

    return medicines;

  }
}
