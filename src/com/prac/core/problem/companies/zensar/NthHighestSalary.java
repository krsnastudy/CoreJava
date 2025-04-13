package com.prac.core.problem.companies.zensar;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NthHighestSalary {
    public static void main(String[] args) {
        {
            int noOfRecords = 5000; // How many records you want
            PopulateEmpData populate = new PopulateEmpData();
            List<Employee> empList = populate.populateEmpData(noOfRecords);
            int rankIdx = 2;
// Map(Dpet, List<Empolyees>)

            empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                    .entrySet().stream()
                    .forEach(e -> {
                        System.out.println(e.getKey() + " -- " + e.getValue().stream()
                                .sorted(Comparator.comparingDouble(Employee::geteSal).reversed())
                                .limit(5)
                                .map(m -> m.geteNumber() + "--" + m.geteSal()).collect(Collectors.joining(", ")));
                    });
            System.out.println("\n" + rankIdx + " Highest Salaried");
            empList.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                    .entrySet().stream()
                    .forEach(e -> {
                        System.out.println("Department: " + e.getKey() +
                                e.getValue().stream()
                                        .sorted(Comparator.comparingDouble(Employee::geteSal).reversed())
                                        .collect(Collectors.toList())
                                        .get(rankIdx - 1).toString()
                        );
                    });
        }
    }
}
/*
* 2nd highest salary dept wise
*
* */