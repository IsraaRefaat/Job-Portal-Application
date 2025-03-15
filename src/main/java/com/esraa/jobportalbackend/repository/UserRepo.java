package com.esraa.jobportalbackend.repository;


import com.esraa.jobportalbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

     User findByUsername(String username);

}
