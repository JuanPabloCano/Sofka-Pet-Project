package com.sofka.petproject.EmployeeService;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeRepository.EmployeeRepository;
import com.sofka.petproject.EmployeeValidator.EmployeeValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class EmployeeService{

    public static final String ID_NOT_FOUND = "Id no encontrado";

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees(){
        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel save(EmployeeModel employeeModel){
        return employeeRepository.save(employeeModel);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    public EmployeeModel getById(Long id){
         return employeeRepository.findById(id)
                 .orElseThrow(() -> new EmployeeValidationException(ID_NOT_FOUND));
    }
}
