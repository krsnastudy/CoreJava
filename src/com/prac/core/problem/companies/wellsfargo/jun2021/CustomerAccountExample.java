package com.prac.core.problem.companies.wellsfargo.jun2021;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerAccountExample {

    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer(1, "Krishna"),
                new Customer(2, "John"),
                new Customer(3, "Sara")
        );

        List<Account> accounts = Arrays.asList(
                new Account(1, "Savings"),
                new Account(1, "Current"),
                new Account(2, "Savings"),
                new Account(3, "Savings"),
                new Account(3, "Current"),
                new Account(3, "Loan")
        );

        // Step 1: Group Accounts by customerId and collect distinct account types
        Map<Integer, Set<String>> customerAccountTypes = accounts.stream()
                .collect(Collectors.groupingBy(
                        Account::getCustomerId,
                        Collectors.mapping(Account::getAccountType, Collectors.toSet())
                ));
        System.out.println("custAccounts :: "+customerAccountTypes);

        Map<Integer, TreeSet<String>> treeSetMap =
                accounts.stream()
                        .collect(Collectors.groupingBy(Account::getCustomerId, Collectors.mapping(Account::getAccountType, Collectors.toCollection(TreeSet::new))));
        System.out.println("  TreeSetMap :: "+treeSetMap);

        // Step 2: Find Customers who have more than one account type
        List<Customer> customersWithMultipleAccountTypes = customers.stream()
                .filter(cust -> customerAccountTypes.containsKey(cust.getCustomerId()))
                .filter(cust -> customerAccountTypes.get(cust.getCustomerId()).size() > 1)
                .collect(Collectors.toList());


        // Step 3: Output
        customersWithMultipleAccountTypes.forEach(cust ->
                System.out.println(cust.getName() + " has multiple account types.")
        );

        List<Customer> customerList = customers.stream()
                .filter(customer ->
                        (customerAccountTypes.containsKey(customer.getCustomerId())) &&
                                (customerAccountTypes.get(customer.getCustomerId()).size() > 1)
                )
                .collect(Collectors.toList());
        System.out.println("Customers who have Multiple Accounts are :: "+customerList.stream().map(Customer::getName).collect(Collectors.joining(", ")));
    }
}
