package com.prac.core.problem.companies.HCL.apr2025;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class commonEmpList {

    public static void main(String args[]) {

        List<EmployeeDetails> list1 = Arrays.asList(
                new EmployeeDetails(1, "John"),
                new EmployeeDetails(2, "Alice"),
                new EmployeeDetails(3, "Bob")
        );

        List<EmployeeDetails> list2 = Arrays.asList(
                new EmployeeDetails(2, "Alice"),
                new EmployeeDetails(4, "David"),
                new EmployeeDetails(3, "Bob")
        );


        // Print common employees
        list1.stream()
                .filter(list2::contains)
                .forEach(System.out::println);

        Set<EmployeeDetails> employeeSet = new HashSet<>(list2);

        list1.stream()
                .filter(employeeSet::contains)
                .forEach(System.out::println);

        List<EmployeeDetails> distinctEmployees = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Merge:");
        distinctEmployees.forEach(System.out::println);
    }
}


class EmployeeDetails {
    private int id;
    private String name;

    public EmployeeDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetails that = (EmployeeDetails) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}
