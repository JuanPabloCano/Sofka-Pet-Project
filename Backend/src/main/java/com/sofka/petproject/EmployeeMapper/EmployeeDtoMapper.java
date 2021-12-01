package com.sofka.petproject.EmployeeMapper;

import com.sofka.petproject.EmployeeModel.EmployeeModel;
import com.sofka.petproject.EmployeeValidator.EmployeeValidationException;
import com.sofka.petproject.EmployeeValidator.EmployeeValidator;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {EmployeeValidator.class}, componentModel = "spring")
public interface EmployeeDtoMapper {


    // Conversor entidad a DTO
    EmployeeDto entityToDto(EmployeeModel employeeModel) throws EmployeeValidationException;

    //Conversor DTO a entidad
    EmployeeModel dtoToEntity(EmployeeDto employeeDto) throws EmployeeValidationException;

    // Conversor de entidad a DTO para mostrar la lista completa
    List<EmployeeDto> entitiesToDto(List<EmployeeModel> employeeModels) throws EmployeeValidationException;

}
