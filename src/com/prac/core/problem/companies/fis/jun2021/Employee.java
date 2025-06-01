package com.prac.core.problem.companies.fis.jun2021;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private long id;
    private String name;
    private double salary;
    private String department;

    public Employee(long id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // Setter for salary (optional, but good for examples)
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    // Implement Comparable for natural ordering (e.g., by ID ascending)
    @Override
    public int compareTo(Employee other) {
        return Long.compare(this.id, other.id);
    }

    // Override equals and hashCode for proper Map behavior
    @Override
    public boolean equals(Object object) {
        if(this==object) return true;
        if(object==null || getClass() !=object.getClass()) return false;
        Employee employee = (Employee)object;
        return (id==employee.getId()) && (name.equalsIgnoreCase(employee.getName()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}