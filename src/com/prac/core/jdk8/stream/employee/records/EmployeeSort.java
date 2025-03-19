package com.prac.core.jdk8.stream.employee.records;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeSort {

    public static void main(String[] args) {
        int noOfRecords = 1000; // How many records you want

        // Creating a list of employees
        List<Employee> emp = new ArrayList<>();
        emp=PopulateEmpData.populateEmpData(noOfRecords);

        Function<Employee, String> deptFunc = Employee::employeeDepartment;
        Function<Employee, Integer> ageFunc = Employee::employeeAge;

        /*Print Deptwise highest Salary*/
        emp.stream()
           .collect(Collectors.groupingBy(deptFunc))
           .entrySet().stream()
                .forEach(e->{
                    System.out.println(
                            "Department: "+e.getKey()+" Highest Salary :: "
                            + e.getValue().parallelStream().collect(Collectors.maxBy(Comparator.comparing(Employee::employeeSal))).map(m->"[ID ("+m.employeeNumber()+") - Name("+m.firstName()+") ] "+m.employeeSal()).get().toString()
                    );
                });
        ;

    }
}
