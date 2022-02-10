package com.example.springlogin.services;


import com.example.springlogin.UserRepository;
import com.example.springlogin.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserModel foundedUser = userRepository.findByUsername(username);
         if(foundedUser == null )   return null;
         String name = foundedUser.getUsername();
         String pwd = foundedUser.getPassword();
         return new User(name, pwd, new ArrayList<>());
    }
}
