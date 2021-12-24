package com.prac.core.jdk8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByFirstLastName {

	public static void main(String[] args) {

		ArrayList<Employee> employees = getUnsortedEmployeeList();

		System.out.println("BeforeSorting");
		employees.forEach(e -> System.out.println("Name: " + e.getfName() + " " + e.getlName()));

		// Compare by first name and then last name
		Comparator<Employee> compareByName = Comparator.comparing(Employee::getfName).thenComparing(Employee::getlName)
				.thenComparing(Employee::getAge);

		List<Employee> sortedEmployees = employees.stream().sorted(compareByName).collect(Collectors.toList());

//        System.out.println(sortedEmployees);
		System.out.println("\nAfterSorting");
		sortedEmployees.forEach(e -> System.out.println("Name: " + e.getfName() + " " + e.getlName()));
	}

	private static ArrayList<Employee> getUnsortedEmployeeList() {
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(2l, "Lokesh", "Gupta"));
		list.add(new Employee(1l, "Alex", "Gussin"));
		list.add(new Employee(4l, "Brian", "Sux"));
		list.add(new Employee(5l, "Neon", "Piper"));
		list.add(new Employee(8l, "David", "Beckham"));
		list.add(new Employee(7l, "Alex", "Beckham"));
		list.add(new Employee(6l, "Brian", "Suxena"));
		return list;
	}
}