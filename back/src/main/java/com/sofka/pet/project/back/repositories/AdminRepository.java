package com.sofka.pet.project.back.repositories;

import com.sofka.pet.project.back.models.AdminModel;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminModel, Long> {

    public abstract AdminModel findByUsernameAndPassword(String username, String password);
    
}
