package com.solid.demo.service;

import com.solid.demo.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;
/*
without adhering open and close principal
@Service
public class PaymentProcessor {

    // VIOLATION: Adding a new payment type requires modifying this method.
    public void process(String type, double amount) {
        if (type.equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment of $" + amount);
        } else if (type.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }
}
/
 */

//with open close principal

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentProcessor {
    private final List<PaymentStrategy> strategies;

    // Spring auto-injects all PaymentStrategy beans here
    public PaymentProcessor(List<PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public void process(String type, double amount) {
        strategies.stream()
                .filter(s -> s.supports(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported payment type: " + type))
                .pay(amount);
    }
}

