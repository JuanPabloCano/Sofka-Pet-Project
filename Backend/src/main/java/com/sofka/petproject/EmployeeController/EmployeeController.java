package com.sofka.petproject.EmployeeController;

import com.sofka.petproject.EmployeeDto.EmployeeDto;
import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeService.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "api/v1/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.list()
                .stream()
                .map(mapper -> modelMapper.map(mapper, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "api/v1/employee")
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {

        // Mapper DTO a Entity
        EmployeeModel employeeModel = modelMapper.map(employeeDto, EmployeeModel.class);
        EmployeeModel employeeSave = employeeService.save(employeeModel);

        // Mapper Entity a Dto
        EmployeeDto employeeDtoMap = modelMapper.map(employeeSave, EmployeeDto.class);

        return new ResponseEntity<>(employeeDtoMap, HttpStatus.CREATED);
    }

    @PutMapping(value = "api/v1/employee")
    public EmployeeModel update(@RequestBody EmployeeModel employeeModel) {
        if (employeeModel.getId() != null) {
            return employeeService.save(employeeModel);
        }
        throw new RuntimeException("Id no encontrado");
    }

    @DeleteMapping(value = "api/{id}/employee")
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @GetMapping(value = "api/{id}/employee")
    public ResponseEntity<EmployeeDto> getByID(@PathVariable("id") Long id) {
        EmployeeModel employeeModel = employeeService.getById(id);

        // Mapper Entity a Dto
        EmployeeDto employeeDto = modelMapper.map(employeeModel, EmployeeDto.class);

        return ResponseEntity.ok().body(employeeDto);
    }
}
