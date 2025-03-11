package com.prac.core.jdk8.stream.employee;

import com.prac.core.jdk8.stream.employee.data.Department;
import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.Math.round;

public class StreamHandsOn {
    public static void main(String[] args) {
        PopulateEmpData populate = new PopulateEmpData();

        int noOfRecords = 50; // How many records you want
        List<EmployeeExt> empData = new ArrayList<EmployeeExt>();
        empData = populate.populateEmployeeMoreDetails(noOfRecords);

        //Group the Employees by Dept
        System.out.println("\nGroup the Employees by Age");
        empData.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpAge)).entrySet().forEach(System.out::println);

        //Find the count of male and female employees present in the organization.
        System.out.println("\nFind the count of male and female employees present in the organization.");
        empData.stream()
                .distinct()
                .sorted(Comparator.comparing(EmployeeExt::getEmpGender))
                .collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.counting()))
                .entrySet().stream()
                .forEach(e-> System.out.println(e.getKey()+" --> "+e.getValue()));
        ;

        System.out.println("\nNames of all departments in the organization ");
        empData.stream().map(Employee::getDepartment).distinct().
                forEach(System.out::println);

        System.out.println("\nEmployee details whose age is greater than 28");
        System.out.println(empData.stream().filter(p->p.getEmpAge()>28).toList().size());

        int maxAge = empData.stream().max(Comparator.comparing(EmployeeExt::getEmpAge)).get().getEmpAge();
        System.out.println("\nMaximum age of Employee: " +maxAge);

        int minAge = empData.stream()
//                .sorted(Comparator.comparing(EmployeeExt::getEmpAge).reversed())
//                .peek(p->System.out.println(p.geteNumber()+" -- "+p.getEmpAge()))
                .collect(Collectors.minBy(Comparator.comparing(EmployeeExt::getEmpAge)))
                .get().getEmpAge();
        System.out.println("\nMinimum age of Employee: " +minAge);

        System.out.println("\nAverage age of Male and Female Employees:: ");
        empData.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.averagingDouble(EmployeeExt::getEmpAge))).entrySet().forEach(e->System.out.println(e.getKey()+" "+Math.round(e.getValue())));

        System.out.println("\nNo of employees in each department");
        empData.stream().collect(Collectors.groupingBy(EmployeeExt::getDepartment, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<Department.DepartmentCode, Long>comparingByValue()).forEach(System.out::println);

        System.out.println("\nOldest employee details::");
        EmployeeExt empOldAge = empData.stream().max(Comparator.comparing(EmployeeExt::getEmpAge)).get();
        System.out.println(empOldAge);

        System.out.println("\nEmployees whose age is greater than 75 and less than 75");
        empData.stream().collect(Collectors.partitioningBy(p->p.getEmpAge()>75)).entrySet().forEach(System.out::println);

        System.out.println("Max no of employees present in Dept :: ");
        System.out.println(empData.stream().collect(Collectors.groupingBy(EmployeeExt::getDepartment, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());

        System.out.println("Department names where the number of employees in the department is over 9 :: ");
        System.out.println(empData.stream().collect(Collectors.groupingBy(EmployeeExt::getDepartment, Collectors.counting())).entrySet().stream().filter(f->f.getValue()>9).collect(Collectors.toList()));

        System.out.println("\nPrint average and total salary of the organization.");
        System.out.println(empData.stream().collect(Collectors.summarizingDouble(EmployeeExt::geteSal)));

        System.out.println("\nHighest salary dept wise:: \n" +
        empData.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().max(Comparator.comparingDouble(Employee::geteSal))))));

        System.out.println("\nPrint Average salary of each department");
        System.out.println(empData.stream().collect(Collectors.groupingBy(EmployeeExt::getDepartment, Collectors.averagingDouble(EmployeeExt::geteSal))));

        System.out.println("\nHighest Salary in the organisation : ");
        System.out.println(empData.stream().collect(Collectors.maxBy(Comparator.comparing(EmployeeExt::geteSal))).get());

        int rank = 10;
        System.out.println("Nth Highest Salary in the organisation : "+(rank-1)+"th");
        EmployeeExt empHighSal = empData.stream().sorted(Comparator.comparing(EmployeeExt::geteSal).reversed()).collect(Collectors.toList()).get(rank-1);
        System.out.println(empHighSal);

        System.out.println("\nFind highest paid salary in the organisation based on gender.");
        empData.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.toList()))
                .entrySet().stream()
                .forEach(entry->{
                    System.out.println(entry.getKey()+" -- "+entry.getValue().stream().max(Comparator.comparing(EmployeeExt::geteSal)).get());
                });

        System.out.println("\nFind lowest paid salary in the organisation based in the organisation by Gender");
        System.out.println(empData.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.minBy((t1, t2) -> (int) (t1.geteSal() - t2.geteSal())))));
    }
}


/*
https://medium.com/@veenaraofr/java8-stream-api-commonly-asked-questions-about-employee-highest-salary-99c21cec4d98
*
**/