package com.sofka.pet.project.back.repositories;

import com.sofka.pet.project.back.models.AdminModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Long> {

    public abstract AdminModel findByUserAdminAndPasswordAdmin(String userAdmin, String passwordAdmin);
    
}
