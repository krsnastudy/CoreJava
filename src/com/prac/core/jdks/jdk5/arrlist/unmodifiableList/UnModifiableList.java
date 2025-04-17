package com.prac.core.jdks.jdk5.arrlist.unmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UnModifiableList {
    public static void main(String[] args) {
        List<Employee> immutableList = List.of(
                new Employee(1, "Alice", 15000),
                new Employee(2, "Bob", 20000)
        );

// This will throw UnsupportedOperationException
//        immutableList.add(new Employee(3, "Charlie", 25000));
//        immutableList.set(0, new Employee(4, "David", 18000)); // Exception
        System.out.println(immutableList);



        /**/

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 15000));
        employees.add(new Employee(2, "Bob", 20000));

// Wrap it in an unmodifiable list
        List<Employee> immutableList1 = Collections.unmodifiableList(employees);

// Try modifying
//        immutableList1.add(new Employee(3, "Eve", 30000)); // Throws exception
/*
* Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
	at com.prac.core.jdks.jdk5.arrlist.unmodifiableList.UnModifiableList.main(UnModifiableList.java:33)
* */

        /***/
        List<Employee> mutableList = Arrays.asList(
                new Employee(1, "Alice", 15000),
                new Employee(2, "Bob", 20000)
        );

// Convert to list of *copies* of immutable Employee objects
        List<Employee> deepImmutableList = Collections.unmodifiableList(
                mutableList.stream()
                        .map(e -> new Employee(e.getId(), e.getName(), e.getSalary())) // Defensive copy
                        .collect(Collectors.toList())
        );
        System.out.println(deepImmutableList);
    }
}
