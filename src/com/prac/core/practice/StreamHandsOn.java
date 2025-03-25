package com.prac.core.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;

public class StreamHandsOn {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {

		int noOfRecords = 50; // How many records you want
		List<Employee> empList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();

		empList = populate.populateEmpData(noOfRecords);
//		System.out.println(empList);

		// Highest Salaried Employee
		System.out.println("Highest Salary: "
				+ empList.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).findFirst().get());

		// Lowest Salary
		System.out.println(
				"Lowest Salary: " + empList.stream().sorted(Comparator.comparing(Employee::geteSal)).findFirst().get());

		// Second Highest Salaried
		int rank = 2;
		System.out.println(rank + " Highest Salaried: " + empList.stream()
				.sorted(Comparator.comparing(Employee::geteSal)).collect(Collectors.toList()).get(rank - 1));

		// Highest Salary Each Departmentwise
		System.out.println();
		empList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y)->{
			System.out.println("Department: "+x);
			System.out.println(y.stream().sorted(Comparator.comparing(Employee::geteSal)).collect(Collectors.toList()).get(rank-1));
		});
		
		/****** Extra Details *********/
		System.out.println();
		List<EmployeeExt> empDet = new ArrayList<EmployeeExt>();
		empDet = populate.populateEmployeeMoreDetails(150);
		
		// Employees Avg salary by Gender 
		empDet.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.averagingDouble(EmployeeExt::geteSal))).forEach((x,y)->System.out.println("Gender : "+x+" --> Avg. Salary: "+y));

		//find the employee in each branch who‘s is salary greater than 10000
		empDet.stream().collect(Collectors.groupingBy(EmployeeExt::getDepartment)).forEach((x,y)->{
			System.out.println("\nDepartment : "+x+" who's salary greater than 10000");
			System.out.println(y.stream().filter(f->f.geteSal()>10000).map(m->m.getfName()+" "+m.getlName()).collect(Collectors.joining(", ")));
		});
		
		// Convert List to Map
		System.out.println("\nConvert List to Map: "+empDet.stream()
			.sorted(Comparator.comparing(EmployeeExt::geteNumber))
			.collect(Collectors.toMap(EmployeeExt::geteNumber, Function.identity(), (o, n)-> n, LinkedHashMap::new)));
		
		//******** Sum of Salary *********
		System.out.println("Summary: "+empDet.stream().collect(Collectors.summarizingDouble(EmployeeExt::geteSal)));
		
	}

}
