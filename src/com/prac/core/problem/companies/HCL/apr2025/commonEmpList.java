package com.prac.core.problem.companies.HCL.apr2025;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class commonEmpList {

    public static void main(String args[]) {

        // Create first list of employees
        List<EmployeeDetails> list1 = Arrays.asList(
                new EmployeeDetails(1, "John"),
                new EmployeeDetails(2, "Alice"),
                new EmployeeDetails(3, "Bob")
        );

        // Create second list of employees
        List<EmployeeDetails> list2 = Arrays.asList(
                new EmployeeDetails(2, "Alice"),
                new EmployeeDetails(4, "David"),
                new EmployeeDetails(3, "Bob")
        );

        // ✅ Find and print common employees using `contains()` on list2
        // NOTE: Relies on proper implementation of equals() and hashCode()
        System.out.println("Logic 1 :: ");
        list1.stream()
                .filter(list2::contains)         // filter elements present in both lists
                .forEach(System.out::println);   // print common employees

        System.out.println("\nLogic 2 :: ");
        // ✅ Optimized: Use a Set for better performance (O(1) lookup)
        Set<EmployeeDetails> employeeSet = new HashSet<>(list2);  // convert list2 to a set

        list1.stream()
                .filter(employeeSet::contains)   // check if list1 elements exist in set
                .forEach(System.out::println);   // print common employees

        // ✅ Merge both lists and remove duplicates using distinct()
        List<EmployeeDetails> distinctEmployees = Stream
                .concat(list1.stream(), list2.stream()) // merge streams
                .distinct()                      // remove duplicates (uses equals() internally)
                .collect(Collectors.toList());   // collect into list

        System.out.println("\n*** Merge Two Lists ***");
        distinctEmployees.forEach(System.out::println); // print merged unique employees
    }
}

// 👇 Class representing employee details
class EmployeeDetails {
    private int id;
    private String name;

    public EmployeeDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ Override equals() to compare both id and name for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                     // reference check
        if (o == null || getClass() != o.getClass())    // null and class check
            return false;
        EmployeeDetails that = (EmployeeDetails) o;
        return id == that.id && name.equals(that.name); // compare fields
    }

    // ✅ Override hashCode() based only on id (could use both id and name for better uniqueness)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ✅ To print employee details meaningfully
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}