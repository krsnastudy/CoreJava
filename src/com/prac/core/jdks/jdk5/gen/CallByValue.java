package com.prac.core.jdks.jdk5.gen;

public class CallByValue {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "John";
        System.out.println("B4: " + e.name);
        changeEmployee(e);
        System.out.println("A4: " + e.name);  // Output: Krishna

        e.name = "Vishnu";
        reassignEmployee(e);
        System.out.println("reassignEmployee: " + e.name);  // Output: Vishnu
    }

    static void changeEmployee(Employee emp) {
        emp.name = "Krishna";  // Modifying the object's field
    }

    static void reassignEmployee(Employee emp) {
        emp = new Employee();
        emp.name = "New Name";
        System.out.println("reassignEmployee(): " + emp.name);  // Output: New Name
    }
}

class Employee {
    String name;
}