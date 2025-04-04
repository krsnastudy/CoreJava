package com.prac.core.jdks.jdk5.design.PortandAdapter;

public class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void pay(double amount) {
        paymentPort.processPayment(amount);
    }
}
