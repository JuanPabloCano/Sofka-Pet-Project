package com.back.back.EmployeeModel;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String lastName;
    private String email;
}

