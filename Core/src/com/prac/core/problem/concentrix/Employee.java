package com.prac.core.problem.concentrix;

public class Employee {

	private String name;
	private int age;
	
	public Employee(String name, int age) {
//		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	public String toStringNew() {
		return "EmpName=" + name + ", EmpAge=" + age ;
	}

}