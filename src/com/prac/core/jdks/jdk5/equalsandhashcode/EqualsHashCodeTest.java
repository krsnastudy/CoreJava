package com.prac.core.jdks.jdk5.equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("John", 80000);
		Employee e2 = new Employee("John", 80000);

		Set<Employee> employees = new HashSet<>();

		employees.add(e1);
		employees.add(e2);

//		System.out.println(employees);
		employees.forEach(x->System.out.println(x));
	}

}
