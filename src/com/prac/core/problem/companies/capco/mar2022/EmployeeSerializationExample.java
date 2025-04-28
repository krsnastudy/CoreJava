package com.prac.core.problem.companies.capco.mar2022;

import java.io.*;

public class EmployeeSerializationExample {
    public static void main(String[] args) {
        // Create Employee and Address objects
        Address address = new Address("1234 Main St", "Springfield", "IL");
        Employee employee = new Employee(1, "John Doe", address);

        // Serialize the Employee object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            out.writeObject(employee);
            System.out.println("Employee object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the Employee object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee deserializedEmployee = (Employee) in.readObject();
            System.out.println("Deserialized Employee: " + deserializedEmployee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
