package com.sofka.petproject.EmployeeRepository;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}
