package com.prac.core.jdk5.design.builder;

public class EmployeeTest {
	public static void main(String[] ars) {
		Employee.Builder emplBuilder = new Employee.Builder();

		Employee employee = emplBuilder.setName("baeldung").setAge(12).setDepartment("Builder Pattern").build();

		System.out.println(employee);
	}
}
