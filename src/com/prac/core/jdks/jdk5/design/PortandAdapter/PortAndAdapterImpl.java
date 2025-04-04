package com.prac.core.jdks.jdk5.design.PortandAdapter;

public class PortAndAdapterImpl {
    public static void main(String[] args) {
        PaymentPort stripe = new StripeAdapter();
        PaymentService service = new PaymentService(stripe);
        service.pay(250.0);
    }
}
