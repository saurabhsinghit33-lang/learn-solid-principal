package com.solid.demo.strategy;

public interface PaymentStrategy {
    boolean supports(String type);
    void pay(double amount);
}
