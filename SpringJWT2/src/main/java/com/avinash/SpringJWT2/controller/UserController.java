package com.avinash.SpringJWT2.controller;

import com.avinash.SpringJWT2.model.User;
import com.avinash.SpringJWT2.service.JwtService;
import com.avinash.SpringJWT2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //all the instances
    @Autowired
    UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    //homepage
    @GetMapping("/")
    public String home(){
        return  "Hello World...!";
    }

    //register
    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.register(user);
    }

    //login
    @PostMapping("login")
    public String login(@RequestBody User user){

        //we must create Authentication object
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else{
            return "False";
        }
    }

}
