package com.sofka.petproject.EmployeeValidator;

import org.springframework.stereotype.Component;


@Component
public class EmployeeValidator {

    public int validateId(int id) throws EmployeeValidationException {
        if (id == -1){
            throw new EmployeeValidationException("Id erróneo");
        }
        return id;
    }
}
