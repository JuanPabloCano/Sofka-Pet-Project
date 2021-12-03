package com.sofka.pet.project.back.Repositories;

import com.sofka.pet.project.back.Models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}
