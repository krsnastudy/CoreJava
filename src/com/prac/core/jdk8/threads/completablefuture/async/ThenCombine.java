package com.prac.core.jdk8.threads.completablefuture.async;

import com.prac.core.jdk8.stream.employee.data.Department;
import com.prac.core.jdk8.stream.employee.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ThenCombine {
    static final int noOfRecords = 1000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Map<Department.DepartmentCode, Long>> empFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Department: "+Thread.currentThread().getName());
            return EmployeeDB.fetchEmployees(noOfRecords)
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        });

        CompletableFuture<List<Integer>> pincodeFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Pincode: "+Thread.currentThread().getName());
            return EmployeeDB.fetchEmployees(noOfRecords)
                    .stream()
                    .map(Employee::getePincode)
                    .collect(Collectors.toList());
        });

        CompletableFuture<String> finalFuture = empFuture.thenCombine(pincodeFuture, (dept, pin) -> (dept + " -- " + pin));
        System.out.println(finalFuture.get());
    }

}
