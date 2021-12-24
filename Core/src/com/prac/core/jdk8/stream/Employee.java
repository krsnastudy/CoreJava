package com.prac.core.jdk8.stream;

public class Employee {

	private long age;
	private String fName;
	private String lName;

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Employee(long l, String fName, String lName) {
		super();
		this.age = l;
		this.fName = fName;
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", fName=" + fName + ", lName=" + lName + "]";
	}

}
