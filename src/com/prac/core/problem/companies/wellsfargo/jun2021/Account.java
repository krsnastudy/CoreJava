package com.prac.core.problem.companies.wellsfargo.jun2021;

public class Account {
    private int customerId;
    private String accountType;

    // Constructor, Getters, Setters

    public Account(int customerId, String accountType) {
        this.customerId = customerId;
        this.accountType = accountType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerId=" + customerId +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}