package com.solid.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class PayPalPayment implements PaymentStrategy {
    @Override
    public boolean supports(String type) {
        return "PAYPAL".equalsIgnoreCase(type);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
