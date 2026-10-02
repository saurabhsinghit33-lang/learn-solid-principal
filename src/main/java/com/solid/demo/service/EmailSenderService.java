package com.solid.demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    public String sendEmail(){
        System.out.println("Email send ");
        return "Email send";
    }
}
