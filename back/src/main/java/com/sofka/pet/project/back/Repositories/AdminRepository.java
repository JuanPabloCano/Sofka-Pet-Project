package com.sofka.pet.project.back.Repositories;

import com.sofka.pet.project.back.Models.AdminModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Long> {

    AdminModel findByUserAdminAndPasswordAdmin(String userAdmin, String passwordAdmin);
    
}
