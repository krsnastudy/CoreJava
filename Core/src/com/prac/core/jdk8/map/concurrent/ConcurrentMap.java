package com.prac.core.jdk8.map.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class ConcurrentMap {

	public static void main(String[] args) {
		int noOfRecords = 5; // How many records you want
		List<Employee> emp = new ArrayList<Employee>();
		PopulateEmpData exec = new PopulateEmpData();
		emp = exec.populateEmpData(noOfRecords);
//		System.out.println("Emp Size: "+emp.size());
		
//		ConcurrentHashMap<Integer, Employee> cMap = new ConcurrentHashMap<>();

		ConcurrentHashMap<Integer, Employee> cMap = emp.stream().distinct().collect(
				Collectors.toMap(Employee::geteNumber, Function.identity(), (prev, next) -> next, ConcurrentHashMap::new));
		
		System.out.println("Employee data size: "+cMap.size()+"\n");
		cMap.forEach((x,y)->System.out.println(x+" --> "+y.toStringSpecific()));;
//		cMap.forEachEntry(0, System.out::println);
//		cMap.forEachKey(0, System.out::println);
//		cMap.forEachValue(0, System.out::println);
	}

}

/*
 * 
 * forEachEntry() - executes the specified function for each entry forEachKey()
 * - executes the specified function for each key forEachValue() - executes the
 * specified function for each value
 * 
 */
