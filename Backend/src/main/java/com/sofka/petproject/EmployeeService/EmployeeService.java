package com.sofka.petproject.EmployeeService;

import com.sofka.petproject.EmployeeDto.EmployeeDto;
import com.sofka.petproject.EmployeeMapper.EmployeeDtoMapper;
import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeRepository.EmployeeRepository;
import com.sofka.petproject.EmployeeValidator.EmployeeValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class EmployeeService{

    public static final String ID_NOT_FOUND = "Id no encontrado";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDtoMapper employeeDtoMapper;


    public List<EmployeeDto> getAllEmployees(){
        return employeeDtoMapper.entitiesToDto(employeeRepository.findAll())
                .stream()
                .map(item -> new EmployeeDto(item.getId(), item.getName(), item.getLastName(),
                        item.getEmail()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<EmployeeModel> save(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeRepository.save(
                employeeDtoMapper.dtoToEntity(employeeDto)), HttpStatus.CREATED);
    }

    public ResponseEntity<EmployeeDto> getById(@PathVariable(value = "id")Long id){
        return new ResponseEntity<>(employeeDtoMapper.entityToDto(employeeRepository
                .findById(id).orElseThrow(() -> new EmployeeValidationException(ID_NOT_FOUND)))
                ,HttpStatus.OK);
    }

    public void deleteById(@PathVariable(value = "id")Long id){
        EmployeeDto employeeDto = employeeDtoMapper.entityToDto(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeValidationException(ID_NOT_FOUND)));
        employeeRepository.deleteById(employeeDto.getId());
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
