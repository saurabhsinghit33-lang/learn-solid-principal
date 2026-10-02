package com.solid.demo.service;

import com.solid.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailSenderService emailSender;

    public UserService(UserRepository userRepository, EmailSenderService emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void registerUser(User user) {
        if (user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password too short");
        }
        userRepository.save(user);
        emailSender.sendWelcomeEmail(user.getEmail());
    }
}