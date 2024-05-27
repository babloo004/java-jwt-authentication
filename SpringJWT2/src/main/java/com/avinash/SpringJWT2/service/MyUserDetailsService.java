package com.avinash.SpringJWT2.service;

import com.avinash.SpringJWT2.model.User;
import com.avinash.SpringJWT2.model.UserPrincipal;
import com.avinash.SpringJWT2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    //all instances
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user==null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}
