package com.prac.core.jdk8.map.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class CCHMapThread implements Runnable{

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		int noOfRecords = 50000; // How many records you want

		List<Employee> emp = new ArrayList<Employee>();
		emp = getData(noOfRecords);
		
		HashMap<Integer, Employee> hMap =
				emp.stream()
				   .collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (o, n)->n, HashMap::new))
				   ;
		
		ConcurrentHashMap<Integer, Employee> cMap =
				emp.parallelStream()
				   .collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (o, n)->n, ConcurrentHashMap::new))
				   ;
		try {
			System.out.println("currentThread Name: "+Thread.currentThread().getName()+" & MapSize: "+cMap.size());
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cMap.entrySet().stream().forEach(System.out::println);
	}
	
	public static List<Employee> getData(int noOfRecords){
		
		PopulateEmpData exec = new PopulateEmpData();

		List<Employee> emp = new ArrayList<Employee>();
		emp = exec.populateEmpData(noOfRecords);
		
		return emp;
	}

}
