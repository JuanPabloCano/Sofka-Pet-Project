package com.sofka.petproject.EmployeeController;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeModel save(@RequestBody EmployeeModel employeeModel){
        return employeeService.save(employeeModel);
    }

    @PutMapping(value = "api/employee")
    public EmployeeModel update(@RequestBody EmployeeModel employeeModel){
        if (employeeModel.getId() != null){
            return employeeService.save(employeeModel);
        }
        throw new RuntimeException("Id no encontrado para actualizar");
    }

    @DeleteMapping(value = "api/{id}/employee")
    public void deleteById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }

    @GetMapping(value = "api/{id}/employee")
    public EmployeeModel getById(@PathVariable("id")Long id){
        return employeeService.getById(id);
    }
}
