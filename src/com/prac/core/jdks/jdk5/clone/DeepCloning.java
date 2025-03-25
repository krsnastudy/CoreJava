package com.prac.core.jdks.jdk5.clone;

public class DeepCloning {

	public static void main(String[] args) throws CloneNotSupportedException {

		Department hr = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", hr);
		Employee dCopy = (Employee) original.clone();

		System.out.println("Before Modification: ");
		System.out.println("Original Object: " + original.toString());
		System.out.println("  Cloned Object: " + dCopy.toString());

		// Let change the department name in cloned object and we will verify in
		// original object
		dCopy.setEmployeeName("Fin");
		dCopy.getDepartment().setName("Finance");

		original.setEmployeeName("AdminOne");

//        System.out.println(original.getDepartment().getName());
//        System.out.println(dCopy.getDepartment().getName());
		System.out.println("\nAfter Modification: ");
		System.out.println("Original Object: " + original.toString());
		System.out.println("  Cloned Object: " + dCopy.toString());
	}

}
