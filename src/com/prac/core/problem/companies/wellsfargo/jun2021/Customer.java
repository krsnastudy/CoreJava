package com.prac.core.problem.companies.wellsfargo.jun2021;

public class Customer {
    private int customerId;
    private String name;

    // Constructor, Getters, Setters

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}