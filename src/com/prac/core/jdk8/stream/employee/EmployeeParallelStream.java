package com.prac.core.jdk8.stream.employee;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class EmployeeParallelStream {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {
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

		Map<Object, Object> dept = empDistinct.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment))
				.entrySet().stream()
				.collect(Collectors.toMap(x -> x, y -> y.getValue().stream().count()));
		
		long start;
		long end;
		
		start = Calendar.getInstance().getTimeInMillis();

		Map<DepartmentCode, List<Employee>> deptStream = 
				empDistinct.stream()
						   .collect(Collectors.groupingBy(Employee::getDepartment));
		
		end = Calendar.getInstance().getTimeInMillis();
		
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