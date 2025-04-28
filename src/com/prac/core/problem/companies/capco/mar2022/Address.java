package com.prac.core.problem.companies.capco.mar2022;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;  // To ensure version compatibility during serialization

    private String street;
    private String city;
    private String state;

    // Constructor
    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state;
    }
}

