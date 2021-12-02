package com.sofka.pet.project.back.repositories;

import com.sofka.pet.project.back.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}
