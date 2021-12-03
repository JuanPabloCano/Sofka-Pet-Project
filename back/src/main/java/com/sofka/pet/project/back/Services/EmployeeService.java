package com.sofka.pet.project.back.Services;

import com.sofka.pet.project.back.Exceptions.NotFoundException;
import com.sofka.pet.project.back.Models.AdminModel;
import com.sofka.pet.project.back.Models.EmployeeModel;
import com.sofka.pet.project.back.Repositories.AdminRepository;
import com.sofka.pet.project.back.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final String NOT_FOUND_EXCEPTION = "Empleado no encontrado";
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
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EXCEPTION));
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
        return adminRepository.findByUserAdminAndPasswordAdmin( username, password );
    }

}
