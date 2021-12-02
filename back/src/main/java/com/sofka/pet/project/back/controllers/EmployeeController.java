package com.sofka.pet.project.back.controllers;

import com.sofka.pet.project.back.models.EmployeeModel;
import com.sofka.pet.project.back.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "api/v1/employees")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "api/v1/employee")
    public EmployeeModel save(@RequestBody EmployeeModel usuario) {
        return this.employeeService.save(usuario);
    }

    @PutMapping(value = "api/v1/employee")
    public EmployeeModel update(@RequestBody EmployeeModel employeeModel) {
        if (employeeModel.getId() != null) {
            return employeeService.save(employeeModel);
        }
        throw new RuntimeException("Id no encontrado para actualizar");
    }

    @DeleteMapping(path = "api/v1/employee")
    public String delete(@PathVariable("id") Long id) {
        boolean ok = this.employeeService.delete(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        }
        return "No se pudo eliminar el usuario con id " + id;
    }

    public EmployeeModel getById(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }
}
