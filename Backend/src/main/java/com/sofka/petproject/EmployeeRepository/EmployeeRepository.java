package com.sofka.petproject.EmployeeRepository;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
