package com.konex.demo.domain.repository;

import java.util.List;

import com.konex.demo.infrastructure.entity.MedicineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface MedicineRepository extends CrudRepository<MedicineEntity, Long> {

}

