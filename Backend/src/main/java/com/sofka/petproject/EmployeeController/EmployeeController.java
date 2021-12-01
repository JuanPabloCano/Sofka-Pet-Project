package com.sofka.petproject.EmployeeController;

import com.sofka.petproject.EmployeeDto.EmployeeDto;
import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeService.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "api/v1/employees")
    public Iterable <EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @PostMapping(value = "api/v1/employee")
    public ResponseEntity<EmployeeModel> save(@RequestBody EmployeeDto employeeDto){
        return employeeService.save(employeeDto);
    }

    @PutMapping(value = "api/v1/employee")
    public ResponseEntity<EmployeeModel> update(@RequestBody EmployeeDto employeeDto){
        if (employeeDto.getId() != null){
            return employeeService.save(employeeDto);
        }
        throw new RuntimeException("Id no encontrado para actualizar");
    }

    @DeleteMapping(value = "api/{id}/employee")
    public void deleteById(@PathVariable(value = "id")Long id){
        employeeService.deleteById(id);
    }

    @GetMapping(value = "api/{id}/employee")
    public ResponseEntity<EmployeeDto> getById(@PathVariable(value = "id")Long id){
        return employeeService.getById(id);
    }
}
