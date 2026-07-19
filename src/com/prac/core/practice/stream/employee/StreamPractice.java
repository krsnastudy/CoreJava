package com.prac.core.practice.stream.employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employeeData = EmployeeData.getEmployeeData(15);
        System.out.println("employeeData :: " + employeeData.size());
        Comparator<Employee> fNameSort = Comparator.comparing(Employee::getFName);
        Comparator<Employee> lNameSort = Comparator.comparing(Employee::getLName);
        Consumer<Employee> employeeConsumer = e -> System.out.println(e.getENumber() + " " + e.getESal() + " " + e.getDeptCode());
        Consumer<List<Employee>> printEmp = c -> c.stream().forEach(e -> employeeConsumer.accept(e));

        /*Sort by First Name*/
        List<Employee> fList =
                employeeData.stream()
//                .sorted(Comparator.comparing(Employee::getFName))
                        .sorted(fNameSort.reversed())
                        .collect(Collectors.toList());
//        System.out.println(fList);

        /**Emp Dept wise Map */
        Map<String, List<Employee>> deptMap = employeeData.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode));

        /** Sort by FName **/
/*        deptMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e->{
                    System.out.print("Dept : "+e.getKey()+" --> \n");
                    e.getValue().stream().sorted(Comparator.comparing(Employee::getFName)).forEach(System.out::println);
                    System.out.println();
                });*/

        Map<String, Stream<Employee>> collectEmp = deptMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream().sorted(Comparator.comparing(Employee::getFName))
                ));
/*        collectEmp.entrySet().stream().forEach(e -> {
            System.out.println("Dept: " + e.getKey());
            printEmp.accept(e.getValue().toList());
            System.out.println();
        });*/

        //4. Find employees earning above 15K
        List<Employee> earnAbv15 = employeeData.stream()
                .filter(f -> f.getESal() >= 15000)
                .collect(Collectors.toList());
//        printEmp.accept(earnAbv15);

        //        5. Sort by Salary
//        employeeData.sort(Comparator.comparing(Employee::getESal));
//        printEmp.accept(employeeData);
        List<Employee> sortBySal =
                employeeData.stream()
                        .sorted(Comparator.comparing(Employee::getESal))
                        .collect(Collectors.toList());
//        printEmp.accept(sortBySal);


//        7. Find Highest Salary Employee
//        printEmp.accept(employeeData.stream().max(Comparator.comparing(Employee::getESal)).stream().toList());
//        printEmp.accept(employeeData.stream().min(Comparator.comparing(Employee::getESal)).stream().toList());
//        21. Partition Employees by Gender
            employeeData.stream().collect(Collectors.partitioningBy(p->p.getGender().equals("MALE")));

//        22. Salary Statistics dept wise
        deptMap.entrySet().stream().forEach(e->{
            System.out.println("Dept: "+e.getKey() + " -- Summary:: "+e.getValue().stream().collect(Collectors.summarizingDouble(Employee::getESal)));
        });

    }
}
