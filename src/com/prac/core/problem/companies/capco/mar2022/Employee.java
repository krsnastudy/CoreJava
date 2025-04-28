package com.prac.core.problem.companies.capco.mar2022;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;  // Ensures version compatibility during serialization

    private int id;
    private String name;
    private Address address;

    // Constructor
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', address=" + address + "}";
    }
}
