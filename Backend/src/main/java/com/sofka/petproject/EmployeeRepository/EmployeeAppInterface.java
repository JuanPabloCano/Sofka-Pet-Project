package com.sofka.petproject.EmployeeRepository;

import com.sofka.petproject.EmployeeModel.EmployeeModel;

import java.util.List;

public interface EmployeeAppInterface {

    List<EmployeeModel> list();

    EmployeeModel save(EmployeeModel employeeModel);

    void delete(Long id);

    EmployeeModel getById(Long id);
}
