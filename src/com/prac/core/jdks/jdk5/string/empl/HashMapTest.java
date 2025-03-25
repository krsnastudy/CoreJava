package com.prac.core.jdks.jdk5.string.empl;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		HashMap<Employee, Integer> hMap = new HashMap<>();
		RemoveDupEmp e = new RemoveDupEmp();
		ArrayList<Employee> eData = e.populateEmpData();

		Employee e1 = new Employee(eData.get(0));
		e1.setePincode(99999);

		for (Employee emp : eData) {
			hMap.put(emp, emp.geteNumber());
		}

		hMap.put(e1, e1.geteNumber());
		// Overridden both equals & hashcode
		hMap.forEach((k, v) -> System.out.print("[Emp:" + k.geteNumber() + " - Pin:" + k.getePincode() + "] "));

	}

}
