package com.prac.core.problem.companies.wipro.may2025.dt24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Employee {
    // Final fields (immutable state)
    private final String name;
    private final String city;
    private final LocalDate doj;
    private final List<String> addressList;

    // Constructor (validates and defensively copies mutable fields)
    public Employee(String name, String city, LocalDate doj, List<String> addressList) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.city = Objects.requireNonNull(city, "City cannot be null");
        this.doj = Objects.requireNonNull(doj, "Date of Joining cannot be null");

        // Defensive copy of the mutable List
        this.addressList = new ArrayList<>(Objects.requireNonNull(addressList, "Address list cannot be null"));
    }

    // Getters (no setters!)
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDoj() {
        return doj;
    }

    // Returns an unmodifiable view of the list
    public List<String> getAddressList() {
        return Collections.unmodifiableList(addressList);
    }

    // Optional: Override toString() for better logging
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", doj=" + doj +
                ", addressList=" + addressList +
                '}';
    }

    // Optional: Override equals() and hashCode() for equality checks
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) &&
                city.equals(employee.city) &&
                doj.equals(employee.doj) &&
                addressList.equals(employee.addressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, doj, addressList);
    }
}