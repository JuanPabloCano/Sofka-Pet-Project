package com.sofka.pet.project.back.controllers;

import com.sofka.pet.project.back.models.AdminModel;
import com.sofka.pet.project.back.models.EmployeeModel;
import com.sofka.pet.project.back.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    

    @GetMapping("api/v1/employees")
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            throw new RuntimeException("No hay empleados registrados");
        }
        return employees;
    }

    @PostMapping("api/v1/employee")
    public EmployeeModel save(@RequestBody EmployeeModel usuario) {
        return this.employeeService.save(usuario);
    }

    @PutMapping("api/v1/employees/{id}")
    public EmployeeModel update(@RequestBody EmployeeModel employeeModel) {
        if (employeeModel.getId() != null) {
            return employeeService.save(employeeModel);
        }
        throw new RuntimeException("No se pudo actualizar el usuario");
    }

    @DeleteMapping("api/v1/employees/{id}")
    public String delete(@PathVariable("id") Long id) {
        boolean ok = employeeService.delete(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        }
        return "No se pudo eliminar el usuario con id " + id;
    }

    @GetMapping("api/v1/employee/{id}")
    public EmployeeModel getById(@PathVariable("id") Long id) {
        EmployeeModel employee = employeeService.getById(id);
        if (employee == null) {
            throw new RuntimeException("No se encontró el usuario con id " + id);
        }
        return employee;
    }

    @PostMapping(value="api/v1/admin")
    public Boolean saveAdmin(@RequestBody AdminModel admin) {
        AdminModel adminDB = employeeService.getByNameAndPassword(admin.getUserAdmin(), admin.getPasswordAdmin());

        if (adminDB == null) {
            return false;
        }
        return true;
    }
    
    

}
