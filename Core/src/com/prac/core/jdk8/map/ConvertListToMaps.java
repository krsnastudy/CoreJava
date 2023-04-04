package com.prac.core.jdk8.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class ConvertListToMaps {

	public static void main(String[] args) throws Exception {
//		TreeMap<Employee, Integer> eMap = new TreeMap<>();

		int noOfRecords = 3; // How many records you want
		List<Employee> emp = new ArrayList<Employee>();
		PopulateEmpData exec = new PopulateEmpData();
		emp = exec.populateEmpData(noOfRecords);
		
		System.out.println("Actual Data:");
		emp.forEach(y->System.out.println(y.toStringSpecific()));

		/* Adding List to HashMap */
		Map<Integer, Employee> hMap = emp.stream().distinct()
				.collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (x, y) -> x, HashMap::new));

		System.out.println("\nHashMap: ");
		hMap.forEach((x,y)->System.out.println(x + "--" + y.toStringSpecific()));
//		System.out.println(hMap);
		
		/* Adding List to TreeMap */
		Map<Integer, Employee> tMap = emp.stream()// .distinct()
				.collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (e1, e2) -> e1, TreeMap::new));

		System.out.println("\nTreeMap: ");
		tMap.forEach((x,y)->System.out.println(x + "--" + y.toStringSpecific()));
//		System.out.println(tMap);
		
		/* Adding List to LinkedHashMap */
		Map<Integer, Employee> lMap = emp.stream().collect(
				Collectors.toMap(Employee::geteNumber, Function.identity(), (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println("\nLinkedHashMap: ");
		lMap.forEach((x,y)->System.out.println(x + "--" + y.toStringSpecific()));
//		System.out.println(lMap);
		
		ConcurrentHashMap<Integer, Employee> cMap = emp.stream().distinct().collect(
				Collectors.toMap(Employee::geteNumber, Function.identity(), (a, b) -> a, ConcurrentHashMap::new));		
		
		System.out.println("\nConcurrentHashMap: ");
		cMap.forEach((x,y)->System.out.println(x + "--" + y.toStringSpecific()));
//		System.out.println(cMap);
	}
}
