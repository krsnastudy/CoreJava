package com.prac.core.jdk5.gen.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {

		Employee e1 = new Employee(1,"Emp1", 27);
		Employee e2 = new Employee(2,"Emp2", 28);
		Employee e3 = new Employee(3,"Emp3", 29);
		
		Person p1 = new Person(1,"Person1", 27);
		Person p2 = new Person(1,"Person2", 28);
		Person p3 = new Person(1,"Person3", 29);
		
		List<Employee> eList = new ArrayList<>();
		List<Person> pList = new ArrayList<>();
		List<Object> oList = new ArrayList<>();
		
		eList.add(e1);
//		eList.add(p1);
		eList.add(e2);
		eList.add(e3);
		
		pList.add(p1);
//		pList.add(e1);
		pList.add(p2);
		pList.add(p3);
		
		oList.add(e1);
		oList.add(e2);
		oList.add(e3);
		oList.add(p1);
		oList.add(p2);
		oList.add(p3);
		
		System.out.println("Employee Details");
		eList.forEach(System.out::println);
		
		System.out.println("\nPerson Details");
		pList.forEach(System.out::println);
		
		System.out.println("\nEmployee & Person Details");
		oList.forEach(System.out::println);
	}

}
