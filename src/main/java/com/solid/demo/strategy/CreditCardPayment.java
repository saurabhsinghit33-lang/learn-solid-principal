package com.solid.demo.strategy;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean supports(String type) {
        return "CREDIT_CARD".equalsIgnoreCase(type);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
