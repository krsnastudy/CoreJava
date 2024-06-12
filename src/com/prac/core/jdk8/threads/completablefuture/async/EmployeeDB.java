package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class EmployeeDB {
	
	@SuppressWarnings("static-access")
	public static List<Employee> fetchEmployees(int noOfRecords) {
		List<Employee> employeeList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		employeeList = populate.populateEmpData(noOfRecords);
		return employeeList.stream().distinct().collect(Collectors.toList());
	}
}
