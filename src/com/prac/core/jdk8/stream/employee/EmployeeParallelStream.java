package com.prac.core.jdk8.stream.employee;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class EmployeeParallelStream {

    @SuppressWarnings({"static-access", "unused"})
    public static void main(String[] args) {
        Supplier<Long> currTimeInMillSec = () -> Calendar.getInstance().getTimeInMillis();
        int noOfRecords = 100000; // How many records you want
        List<Employee> emp = new ArrayList<Employee>();
        PopulateEmpData exec = new PopulateEmpData();
        emp = exec.populateEmpData(noOfRecords);

//		System.out.println("\n<<< Distinct Employees Data >>>");
        ArrayList<Employee> empDistinct =
                (ArrayList<Employee>) emp.stream()
                        .distinct()
                        .collect(Collectors.toList());
//		System.out.println(empDistinct.size());	
//		empDistinct.forEach(System.out::println);

        LinkedHashMap<Map.Entry<DepartmentCode, List<Employee>>, Long> collectToMap = empDistinct.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(x->x, y->y.getValue().stream().count(), (a,b)->b, LinkedHashMap::new));

        Map<DepartmentCode, Long> dept = empDistinct.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("Deptwise Count :: "+dept);

        long start; long end;
        start = currTimeInMillSec.get();
            Map<DepartmentCode, List<Employee>> deptStream =
                    empDistinct.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));
        end = currTimeInMillSec.get();

        System.out.println("For " + noOfRecords + " records   Normal Stream Took: " + (end - start) + " MilliSeconds");

//start = Calendar.getInstance().getTimeInMillis();
        start = ZonedDateTime.now().toInstant().toEpochMilli();

        Map<DepartmentCode, List<Employee>> deptParallelStream =
                empDistinct.parallelStream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
//end = Calendar.getInstance().getTimeInMillis();

        end = ZonedDateTime.now().toInstant().toEpochMilli();

        System.out.println("For " + noOfRecords + " records Parallel Stream Took: " + (end - start) + " MilliSeconds\n");

        /*
         * dept1.forEach((x,y)->System.out.println(x+" Departement has " + //y
         * y.stream().count()+" Employees" ));
         */
//		System.out.println(dept);
    }
}