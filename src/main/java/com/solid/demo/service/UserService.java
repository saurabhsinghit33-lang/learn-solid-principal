package com.solid.demo.service;

import com.solid.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // VIOLATION: Handling DB connection, business logic, and notifications all in one place.
    public void registerUser(User user) {
        // 1. Business Logic
        if (user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password too short");
        }

        // 2. Database Logic (Simulated)
        System.out.println("Saving user to database: " + user.getFirstName());

        // 3. Notification Logic
        System.out.println("Sending welcome email to: " + user.getEmail());
    }
}