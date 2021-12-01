package com.sofka.petproject.EmployeeDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;

}
