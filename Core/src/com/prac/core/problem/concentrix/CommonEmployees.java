package com.prac.core.problem.concentrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonEmployees {

	public static void main(String[] args) {

		List<Employee> list1 = Arrays.asList(new Employee("RK1", 1), new Employee("RK2", 2), new Employee("RK3", 3));
		List<Employee> list2 = Arrays.asList(new Employee("RK1", 4), new Employee("RK3", 5), new Employee("RK4", 6));
		List<Employee> list3 = Arrays.asList(new Employee("RK5", 7), new Employee("RK6", 8), new Employee("RK3", 9));

		list1.stream().forEach(System.out::println);
		System.out.println();
		list2.stream().forEach(System.out::println);
		System.out.println();
		list3.stream().forEach(System.out::println);
		System.out.println();
		
//		list1.retainAll(list2);
		
		List<String> list2Names=new ArrayList<>();
		list2.stream().forEach(i->list2Names.add(i.getName()));
		
		List<String> list3Names=new ArrayList<>();
		list3.stream().forEach(i->list3Names.add(i.getName()));
		
//		System.out.println(list2Names);
		
		List<Employee> list = 
				list1.stream()
//					  .filter(j->list2Names.contains(j.getName()))
//					  .filter(l-> (list2.stream().map(Employee::getName).peek(System.out::print).collect(Collectors.toList())).contains(l.getName()))
					  .filter(l-> (list2.stream().map(Employee::getName).collect(Collectors.toList())).contains(l.getName()))
//					  .filter(k-> !list3Names.contains(k.getName()))
					  .filter(m-> !(list3.stream().map(Employee::getName).collect(Collectors.toList())).contains(m.getName()))
					  .collect(Collectors.toList());

//		System.out.println(list);
		list.forEach(i->System.out.println(i.toStringNew()));
	}
}

/*
 * 
 * Find Common Employees from List1 & List2 and should not exists in List3
 * 
 */