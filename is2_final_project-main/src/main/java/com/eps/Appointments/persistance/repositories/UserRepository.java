package com.eps.Appointments.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}
