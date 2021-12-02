package com.back.back.EmployeeService;

import com.back.back.EmployeeModel.EmployeeModel;
import com.back.back.EmployeeRepository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeModel save(EmployeeModel employeeModel){
        return employeeRepository.save(employeeModel);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    public EmployeeModel getById(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }
}
