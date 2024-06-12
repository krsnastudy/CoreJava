package com.prac.core.problem.empl_dept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDepartment {

	public static void main(String[] args) {
		List<Employee> empList = getEmployeeData();
		Comparator<Department> deptComp = Comparator.comparing(Department::getDepartmentName);
		
	  // Find all employees who lives in 'Matara' city, sort them by their name and print the names of employees.
		empList.stream()
		       .filter(i->i.getCity().equalsIgnoreCase("Matara"))
			   .sorted(Comparator.comparing(Employee::getName))
//			   .sorted((a, b)->a.getName().compareTo(b.getName()))
//		       .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge).thenComparing(p->p.getDepartment().getNoOfEmployees()))
//			   .sorted(Comparator.comparing(Employee::getAge).thenComparing(p->p.getDepartment().getNoOfEmployees()))
			   .sorted((a, b)->a.getDepartment().getDepartmentName().compareTo(b.getDepartment().getDepartmentName()))
//		       .map(Employee::getDepartment)
//		       .sorted(Comparator.comparing(Department::getDepartmentName))
//		       .forEach(e->System.out.println(e.getName()))
//		       .distinct()
		       .forEach(System.out::println);
		       ;
		       
		       
		       String str = empList.stream()
//		       	.filter(i->i.getCity().equalsIgnoreCase("Matara"))
		       	.sorted(Comparator.comparing(Employee::getName))
		       	.map(i->i.getName())
		       	.collect(Collectors.joining(", "))
		       	;
		       
		       System.out.println("\nCollectors.joining: "+str);
	}//psvm

	public static List<Employee> getEmployeeData() {
		
		Department account = new Department("Account", 75);
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("Tech", 150);

		List<Employee> employeeList = Arrays.asList(new Employee("David", 32, "Matara", account),
				new Employee("Brayan", 25, "Galle", hr), new Employee("JoAnne", 45, "Negombo", ops),
				new Employee("Jake", 65, "Galle", hr), new Employee("Brent", 55, "Matara", hr),
				new Employee("Allice", 23, "Matara", ops), new Employee("Austin", 30, "Negombo", tech),
				new Employee("Gerry", 29, "Matara", tech), new Employee("Scote", 20, "Negombo", ops),
				new Employee("Branden", 32, "Matara", account), new Employee("Iflias", 31, "Galle", hr));

		return employeeList;
		
	}//getEmployeeData

}//EmployeeDepartment


/*
	https://www.javacodegeeks.com/2018/07/java-8-stream-examples.html
*/