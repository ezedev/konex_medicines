package com.konex.demo.application.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.domain.service.CreateNewMedicine;
import com.konex.demo.domain.service.GetAllMedicines;
import com.konex.demo.domain.service.GetMedicineById;
import com.konex.demo.domain.service.UpdateMedicine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicine")
@CrossOrigin(origins = {"http://localhost:3000", "*"})
public class MedicineController {

  private final GetAllMedicines getAllMedicinesUseCase;

  private final GetMedicineById getMedicineByIdUseCase;

  private final UpdateMedicine updateMedicineUseCase;

  private final CreateNewMedicine createNewMedicineUseCase;

  public MedicineController(GetAllMedicines getAllMedicinesUseCase, GetMedicineById getMedicineByIdUseCase,
      UpdateMedicine updateMedicineUseCase, CreateNewMedicine createNewMedicineUseCase) {
    this.getAllMedicinesUseCase = getAllMedicinesUseCase;
    this.getMedicineByIdUseCase = getMedicineByIdUseCase;
    this.updateMedicineUseCase = updateMedicineUseCase;
    this.createNewMedicineUseCase = createNewMedicineUseCase;
  }

  @GetMapping("/medicines")
  public ResponseEntity<List<MedicineResponse>> getAllMedicines() {

    var medicines = getAllMedicinesUseCase.execute();

    return new ResponseEntity<>(medicines, HttpStatus.OK);

  }

  @GetMapping("/medicines/{id}")
  public MedicineResponse getById(@PathVariable Long id) {
    return getMedicineByIdUseCase.execute(id);
  }

  @PutMapping(value = "/medicines/{id}")
  public ResponseEntity<?> update(@RequestBody MedicineRequest medicineRequest, @PathVariable Long id) {

    Optional<MedicineResponse> medicineToUpdate = Optional.ofNullable(getMedicineByIdUseCase.execute(id));
    Map<String, Object> response = new HashMap<>();
    if (medicineToUpdate.isEmpty()) {
      response.put("mensaje", "no se puede editar ,el alumno con id " + id.toString() + " no existe en la base de datos");
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    var result = updateMedicineUseCase.execute(medicineRequest, medicineToUpdate.get());

    response.put("mensaje", "el medicamento se actualizo con exito");
    response.put("alumno", result);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
  }

  @PostMapping("/medicines")
  public ResponseEntity<?> create(@RequestBody MedicineRequest medicineRequest) {

    Map<String, Object> responseMessage = new HashMap<>();

    var responseObject = createNewMedicineUseCase.execute(medicineRequest);

    responseMessage.put("mensaje", "el alumno se creo con exito");
    responseMessage.put("alumno", responseObject);
    return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.CREATED);
  }
}
