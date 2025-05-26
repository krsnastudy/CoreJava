package com.prac.core.problem.companies.wipro.may2025.dt24;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ImmutableEmployee {
    public static void main(String[] args) {
        List<String> addresses = Arrays.asList("123 Main St", "456 Park Ave");
        Employee emp = new Employee("John Doe", "New York", LocalDate.of(2020, 1, 15), addresses);

        System.out.println(emp);

        // Attempting to modify the list (will throw UnsupportedOperationException)
        List<String> empAddresses = emp.getAddressList();
        try {
            empAddresses.add("789 Broadway"); // Fails!
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify address list!");
        }

        // Original list remains unchanged
        System.out.println("Original addresses: " + addresses); // Still has 2 elements
    }
}