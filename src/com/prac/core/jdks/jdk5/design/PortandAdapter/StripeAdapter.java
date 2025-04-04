package com.prac.core.jdks.jdk5.design.PortandAdapter;

public class StripeAdapter implements PaymentPort {
    public void processPayment(double amount) {
        System.out.println("Processed $" + amount + " with Stripe.");
    }
}
