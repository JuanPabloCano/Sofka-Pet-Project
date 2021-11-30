package com.sofka.petproject.EmployeeService;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeRepository.EmployeeAppInterface;
import com.sofka.petproject.EmployeeRepository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService implements EmployeeAppInterface {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeModel> list() {
        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    @Override
    public EmployeeModel save(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(getById(id));
    }

    @Override
    public EmployeeModel getById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }
}
