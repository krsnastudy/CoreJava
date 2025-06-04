package com.prac.core.problem.companies.fis.jun2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap; // To preserve insertion order if needed

public class EmployeeManager {

    public static void main(String[] args) {

        // 1. Create a List of Employee Objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Charlie", 70000.0, "HR"));
        employees.add(new Employee(101, "Alice", 60000.0, "IT"));
        employees.add(new Employee(105, "David", 85000.0, "Finance"));
        employees.add(new Employee(102, "Bob", 75000.0, "IT"));
        employees.add(new Employee(104, "Eve", 60000.0, "HR")); // Same salary as Alice

        System.out.println("--- Original Employee List ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------\n");

        // 2. Employee Object Sorting

        // 2a. Sorting by Natural Order (using Comparable - by ID ascending)
        Collections.sort(employees); // Uses Employee's compareTo method
        System.out.println("--- Sorted by Employee ID (Ascending) ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------\n");

        // 2b. Sorting by Salary (Descending) using Comparator
        // Using a lambda expression for Comparator
        Collections.sort(employees, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("--- Sorted by Salary (Descending) ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------\n");

        // 2c. Sorting by Salary (Descending) then by Name (Ascending) using Comparator
        // Using Comparator.comparing and thenComparing (Java 8+)
        Collections.sort(employees, Comparator.comparing(Employee::getSalary).reversed()
                .thenComparing(Employee::getName));
        System.out.println("--- Sorted by Salary (Desc) then Name (Asc) ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------\n");

        // 2d. Sorting by Department (Ascending) then by Name (Ascending)
        Collections.sort(employees, Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getName));
        System.out.println("--- Sorted by Department (Asc) then Name (Asc) ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------\n");


        // 3. Adding Employee Objects to a Map

        // Using HashMap: Keys (Employee ID) are unique, insertion order is NOT guaranteed.
        Map<Long, Employee> employeeMap = new HashMap<>();

        // Add all employees from the (currently sorted by Department, then Name) list to the map
        for (Employee emp : employees) {
            employeeMap.put(emp.getId(), emp);
        }

        System.out.println("--- Employees in HashMap (Key: Employee ID) ---");
        // Iterating HashMap - note that the order might not be the same as insertion
        for (Map.Entry<Long, Employee> entry : employeeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("\n----------------------------\n");

        // Example of retrieving an employee from the map
        Long empIdToFind = 102L;
        if (employeeMap.containsKey(empIdToFind)) {
            System.out.println("Employee with ID " + empIdToFind + " found: " + employeeMap.get(empIdToFind));
        } else {
            System.out.println("Employee with ID " + empIdToFind + " not found.");
        }

        // Using LinkedHashMap: Keys are unique, insertion order IS guaranteed.
        // This is useful if you want to maintain the order in which elements were added to the map.
        Map<Long, Employee> orderedEmployeeMap = new LinkedHashMap<>();
        // Let's add them in their original ID order for clarity
        List<Employee> originalOrderEmployees = new ArrayList<>();
        originalOrderEmployees.add(new Employee(103, "Charlie", 70000.0, "HR"));
        originalOrderEmployees.add(new Employee(101, "Alice", 60000.0, "IT"));
        originalOrderEmployees.add(new Employee(105, "David", 85000.0, "Finance"));
        originalOrderEmployees.add(new Employee(102, "Bob", 75000.0, "IT"));
        originalOrderEmployees.add(new Employee(104, "Eve", 60000.0, "HR"));

        for(Employee emp : originalOrderEmployees) {
            orderedEmployeeMap.put(emp.getId(), emp);
        }
        System.out.println("--- Employees in LinkedHashMap (Preserves Insertion Order) ---");
        for (Map.Entry<Long, Employee> entry : orderedEmployeeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("\n----------------------------\n");

    }
}