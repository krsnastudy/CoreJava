package com.prac.core.jdks.jdk8.stream.employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;

public class StreamPracticeOne {

	public static void main(String[] args) {
		Consumer<List<Employee>> printEmployee = System.out::println;
		int noOfRecords = 5; // How many records you want
		
		List<Employee> empData = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		empData = populate.populateEmpData(noOfRecords);

		printEmployee.accept(empData);

		/* GroupBy Dept */
		empData.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y)->System.out.println(
				x+" Department --> "+ y.stream().map(z->z.geteNumber()+" - "+z.getfName()).collect(Collectors.joining(", "))
				));
		System.out.println();

		/* Deptwise Count */
		empData.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment))
				.forEach((k,v)-> System.out.println(
						"Dept: " + k + " -- " +
						v.stream().count()
				))
		;
		
		/* Deptwise salary summation */
		empData.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.forEach((x,y)->System.out.println(
					x+" Department Total Salary is " 
			+ y.stream()
			.collect(Collectors.summarizingDouble(Employee::geteSal))
			.getSum()
					));
		
		System.out.println();
		
		/* Deptwise highest salary */
		empData.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.forEach((x,y)->System.out.println(
					x+" Department Highest Salary is " 
			+ y.stream()
			.collect(Collectors.maxBy(Comparator.comparing(Employee::geteSal)))
			.map(z->"[EmpID: "+z.geteNumber()+"]: "+z.geteSal()).get()
			));
		
		System.out.println();
		
		/* Comparator */
		
		Comparator<Employee> comparator = 
				Comparator.comparing(Employee::getfName)
				.thenComparing(Employee::getlName)
				.reversed()
				;

		empData.stream().distinct()
		.sorted(comparator)
//		.forEach(p->System.out.println("EmpId: "+p.geteNumber()+" == FirstName: "+p.getfName()+", LastName: "+p.getlName()))
		;
		
		System.out.println();
		
		/*Emp Age<30 Salary Sum */
		Double d = empData.stream()
		.filter(f->f.geteNumber()>100000)
		.collect(Collectors.summarizingDouble(Employee::geteSal))
		.getSum()
		;
		System.out.println("Sum : "+d);
		
		System.out.println();
		System.out.println("Min: "+empData.stream().min((a,b)-> a.geteNumber()-b.geteNumber()));
		
		
		String str = new String("RadhaKrishna");
		
		Map<Character, Integer> frequencies = str.chars().boxed()
		        .collect(Collectors.toMap(
		                // key = char
		                k -> Character.valueOf((char) k.intValue()),
		                v -> 1,         // 1 occurence
		                Integer::sum)); // counting
		System.out.println("\nFrequencies: "+frequencies);
		
		
		frequencies =  new HashMap<>();
		for(Character c : str.toLowerCase().toCharArray()) {
			frequencies.merge(c, 1, Integer::sum);
		}

		System.out.println("\nFrequencies: "+frequencies);

		TreeMap<Character, Integer> freqTree = new TreeMap<>();
		for(Character c : "GeneratingRandomNumbersinaRange".toLowerCase().toCharArray()){
			freqTree.merge(c, 1, Integer::sum);
		}
		System.out.println("\nFrequencies: "+freqTree);
		System.out.println();

		/*sum of salary using reduce*/
		float s = empData.stream().map(m->m.geteSal()).reduce((float) 0, (a,b)->a+b);

		empData.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x, y)-> System.out.println(x + y.toString()));
	}

}
