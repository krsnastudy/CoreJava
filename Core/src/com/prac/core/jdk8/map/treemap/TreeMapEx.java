package com.prac.core.jdk8.map.treemap;

import java.util.TreeMap;

import com.prac.core.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdk8.stream.employee.data.Employee;

public class TreeMapEx {

	public static void main(String[] args) throws Exception{
		TreeMap<Person, Integer> tMap = new TreeMap<>();
		TreeMap<Employee, Integer> eMap = new TreeMap<>();
		
		Employee e1= new Employee("fName", "lName", 1, 15436, 560037, DepartmentCode.Admin);
		Employee e2= new Employee("fName", "lName", 1, 15436, 560037, DepartmentCode.Admin);
		
		Person p1 = new Person(1, "P1");
		Person p2 = new Person(1, "P1");
		
//		tMap.put(p1, 1);
//		tMap.put(p2, 2);
//		System.out.println(tMap.size());
		
		eMap.put(e1, 10);
		eMap.put(e2, 12);
		System.out.println(eMap.size());
	}
}


class Person{
	private int number;
	private String name;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person[Number=" + number + ", Name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
}