package com.prac.core.jdk5.map.empl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class EmployeeMap {

	public static void main(String[] args) {
		HashMap<Employee,String> employeeMap = new HashMap<Employee,String>();  

	    Employee employee1 = new Employee();    
	    employee1.setId(1);    
	    employee1.setName("Sachin");    
	       

	    employeeMap.put(employee1,"India");
	    employeeMap.forEach((x,y)-> System.out.println(x.hashCode()+" - "+x.toString()+" MapValue: "+y));
	    System.out.println(employeeMap.get(employee1));
	    
//	    employee1.setName("RK");
	    employee1.setId(2);
	    employeeMap.forEach((x,y)-> System.out.println(x.hashCode()+" - "+x.toString()+" MapValue: "+y));
	    System.out.println(employeeMap.get(employee1));
//	    employeeMap.put(employee1,"India");

	    // Some Business logic    
	    // In the second Operation I am updating the same employee with the newly initailized Employee Object

	    Employee employee2 = new Employee();    
	    employee2.setId(1);
	    employee2.setName("Sachin");

	    // Here we wanted to update the same Employee to Japan
	    employeeMap.put(employee2,"Japan");    

	    System.out.println(employeeMap); 	    
	    System.out.println(employeeMap.get(employee1));
	    
	    employeeMap.forEach((x,y)-> System.out.println(x.hashCode()+" MapValue: "+y));
	}

}
