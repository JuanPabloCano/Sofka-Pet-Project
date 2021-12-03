package com.sofka.pet.project.back.services;

import com.sofka.pet.project.back.models.AdminModel;
import com.sofka.pet.project.back.models.EmployeeModel;
import com.sofka.pet.project.back.repositories.AdminRepository;
import com.sofka.pet.project.back.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private AdminRepository adminRepository;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AdminRepository adminRepository) {
        this.employeeRepository = employeeRepository;
        this.adminRepository = adminRepository;
    }

    public List<EmployeeModel> getAllEmployees() {

        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel save(EmployeeModel usuario) {
        return employeeRepository.save(usuario);
    }

    public EmployeeModel getById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public boolean delete(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public AdminModel getByNameAndPassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword( username, password );
    }

}
