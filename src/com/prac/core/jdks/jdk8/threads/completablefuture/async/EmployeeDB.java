package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDB {

    @SuppressWarnings("static-access")
    public static List<Employee> fetchEmployees(int noOfRecords) {
        PopulateEmpData populate = new PopulateEmpData();
        List<Employee> employeeList = populate.populateEmpData(noOfRecords);
        return employeeList.stream().distinct().collect(Collectors.toList());
    }
}
