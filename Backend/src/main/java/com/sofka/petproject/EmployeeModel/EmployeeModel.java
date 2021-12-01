package com.sofka.petproject.EmployeeModel;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "employees")
@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String email;
}
