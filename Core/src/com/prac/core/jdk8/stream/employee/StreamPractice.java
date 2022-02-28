package com.prac.core.jdk8.stream.employee;

import java.util.ArrayList;
import java.util.List;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class StreamPractice {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int noOfRecords = 20; // How many records you want
		List<Employee> employeeList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		employeeList = populate.populateEmpData(noOfRecords);

		
		System.out.println(employeeList);
	}

}
