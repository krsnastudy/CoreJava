package com.prac.core.jdk8.stream.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;
import com.prac.core.jdk8.stream.employee.data.Employee;

public class ListToMaps {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		int noOfRecords = 5; // How many records you want
		List<Employee> eList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		eList = populate.populateEmpData(noOfRecords).stream().distinct().collect(Collectors.toList());
		
		System.out.println("HashMap:");
		Map<Integer, Employee> hMap = eList.stream()
//					.sorted(Comparator.comparing(Employee::geteNumber))
					.collect(Collectors.toMap(x->x.geteNumber(), y->y, (o,n)->o, HashMap::new))
					;
		hMap.forEach((x,y)->System.out.println(y));
		
		System.out.println("\nLinkedHashMap:");
		Map<Integer, Employee> lhMap = hMap.entrySet().stream()
    			.sorted(Map.Entry.comparingByKey())
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n)->o, LinkedHashMap::new))
				;
		lhMap.forEach((x,y)->System.out.println(y));
		
		System.out.println("\nTreeHashMap:");
		Map<Integer, Employee> tMap =
				hMap.entrySet().stream()
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->n, TreeMap::new))
					;
		tMap.forEach((x,y)->System.out.println(y));
		
		eList.stream()
			.sorted(Comparator.comparing(Employee::geteNumber))
			.collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (o,n)->o, LinkedHashMap::new));
	}

}
