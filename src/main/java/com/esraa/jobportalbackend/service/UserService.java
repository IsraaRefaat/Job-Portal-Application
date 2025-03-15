package com.esraa.jobportalbackend.service;


import com.esraa.jobportalbackend.models.User;
import com.esraa.jobportalbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public User saveUser(User user) {
        return repo.save(user);
    }
}
