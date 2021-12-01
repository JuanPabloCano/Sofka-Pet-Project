package com.sofka.petproject.EmployeeMapper;

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
