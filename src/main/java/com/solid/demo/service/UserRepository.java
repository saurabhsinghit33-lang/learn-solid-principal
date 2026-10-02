package com.solid.demo.service;

import com.solid.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {
    public String save(User user){
        return "user data saved";
    }
}
