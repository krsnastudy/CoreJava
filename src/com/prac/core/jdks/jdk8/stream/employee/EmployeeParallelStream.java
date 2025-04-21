package com.prac.core.jdks.jdk8.stream.employee;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.prac.core.jdks.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;

public class EmployeeParallelStream {

    @SuppressWarnings({"static-access", "unused"})
    public static void main(String[] args) {
        Supplier<Long> currTimeInMillSec = () -> Calendar.getInstance().getTimeInMillis();
        int noOfRecords = 1000000; // How many records you want
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

        String strCollect = empDistinct.parallelStream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().map(m -> m.getKey()+" Department Count :: " + m.getValue().size())
                .collect(Collectors.joining("\n"));
        System.out.println(strCollect+"\n");
        System.out.println(noOfRecords+" Employees, Department Wise Split Count :: "+dept);

        Instant now = Instant.now();
        long start; long end;

        start = currTimeInMillSec.get();
            Map<DepartmentCode, List<Employee>> deptStream =
                    empDistinct.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));

        end = currTimeInMillSec.get();
        Duration between = Duration.between(now, Instant.now());

        System.out.println("\nFor " + noOfRecords + " records   Normal Stream Took: " + (end - start) + " MilliSeconds");
        System.out.println("For " + noOfRecords + " records   Normal Stream Took: " +  between.toMinutes() + " Mins, "+ between.getSeconds()+ " Sec, "+
                between.toMillis()+ " ms");

//start = Calendar.getInstance().getTimeInMillis();
        start = ZonedDateTime.now().toInstant().toEpochMilli();
        now = Instant.now();

        Map<DepartmentCode, List<Employee>> deptParallelStream =
                empDistinct.parallelStream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
//end = Calendar.getInstance().getTimeInMillis();

        end = ZonedDateTime.now().toInstant().toEpochMilli();
        between = Duration.between(now, Instant.now());

        System.out.println("\nFor " + noOfRecords + " records Parallel Stream Took: " + (end - start) + " MilliSeconds");
        System.out.println("For " + noOfRecords + " records Parallel Stream Took: " +  between.toMinutes() + " Mins, "+ between.getSeconds()+ " Sec, "+
                between.toMillis()+ " ms");
        /*
         * dept1.forEach((x,y)->System.out.println(x+" Departement has " + //y
         * y.stream().count()+" Employees" ));
         */
//		System.out.println(dept);
    }
}