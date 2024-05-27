package com.avinash.SpringJWT2.service;

import com.avinash.SpringJWT2.model.User;
import com.avinash.SpringJWT2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //all instances
    @Autowired
    UserRepo repo;

    //Bcrypt
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    //register
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

}
