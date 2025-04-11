package com.prac.core.problem.companies.HCL.apr2022;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "RadhaKrishna");
		Employee e2 = new Employee(1, "XYZ");
		Employee e3 = new Employee(2, "XYZ");
		Employee e4 = new Employee(2, "RadhaKrishna");

		Map<Employee, Integer> map = new HashMap<>();
		map.put(e1, e1.getEmployeeId());
		map.put(e2, e2.getEmployeeId());
		map.put(e3, e3.getEmployeeId());
		map.put(e4, e4.getEmployeeId());

		map.entrySet().stream().forEach(x -> System.out.println(x.toString()));
	}

}

/*
 * LIst of employees
 * 
 * EMP - ID, Name
 * 
 * Map(Employee, String)
 * 
 * Emp e1 - 1, RadhaKrishna, Emp e2 - 1, XYZ; Emp e3 - 2, XYZ; Emp e4 - 2,
 * RadhaKrishna;
 * 
 * op : 1 RK, 2 XYZ size?
 * 
 * List<Employee>
 * 
 * Map<Integer, Employee> list.stream().collect(Collectors.toMap(e1.
 * 
 * Anagram String
 */
