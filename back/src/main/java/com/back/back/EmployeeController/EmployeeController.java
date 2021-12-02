package com.back.back.EmployeeController;

import com.back.back.EmployeeModel.EmployeeModel;
import com.back.back.EmployeeService.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(value = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "api/v1/employees")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "api/v1/employee")
    public EmployeeModel save(@RequestBody EmployeeModel employeeModel){
        return employeeService.save(employeeModel);
    }

    @PutMapping(value = "api/v1/employee")
    public EmployeeModel update(@RequestBody EmployeeModel employeeModel){
        if (employeeModel.getId() != null){
            employeeService.save(employeeModel);
        }
        throw new RuntimeException("Id no encontrado para actualizar");
    }

    @DeleteMapping(value = "api/{id}/employee")
    public void deleteById(@PathVariable("id")Long id){
        employeeService.deleteById(id);
    }

    @GetMapping(value = "api/{id}/employee")
    public EmployeeModel getById(@PathVariable("id")Long id){
        return employeeService.getById(id);
    }

}
