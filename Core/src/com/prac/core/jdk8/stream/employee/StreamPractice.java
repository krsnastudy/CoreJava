package com.prac.core.jdk8.stream.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdk8.stream.employee.data.Gender.GenderCode;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class StreamPractice {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int noOfRecords = 200; // How many records you want
		List<Employee> employeeList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		employeeList = populate.populateEmpData(noOfRecords);
//		System.out.println("Given Data"+employeeList);
		
		employeeList.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
		
//		employeeList.stream().sorted((i1, i2)->i2.geteSal()-i1.geteSal()).forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
//		Type mismatch: cannot convert from float to int
		
		//Highest Salaray
		Employee highestSal = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::geteSal))).get();
		System.out.println("\nhighestSal: "+highestSal);
		
		int rank=3;
		
		Employee nthhighSal = employeeList.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).collect(Collectors.toList()).get(rank-1);
		System.out.println(rank+" Highest Salary: : "+nthhighSal+"\n");
		
		System.out.println("/**************** "+rank+" Highest Salary Each Departmentwise *************/");
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.forEach((x,y)->{
				System.out.println("Department: "+x);
				System.out.println(y.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).collect(Collectors.toList()).get(rank).toString());
			});
		System.out.println();
		
		
		/****** Extra Details *********/
		List<EmployeeExt> empDet = new ArrayList<EmployeeExt>();
		empDet = populate.populateEmployeeMoreDetails(30);
		empDet.stream().forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
		
		Map<GenderCode, List<EmployeeExt>> genderMap =
				empDet.stream().collect(Collectors.groupingBy(EmployeeExt::getEmpGender));
		
		// Employees count by Gender 
		String genderLabel = "Employees count by Gender";
		System.out.println("/******** "+genderLabel+" *********/");
		empDet.stream()
			.distinct()
			.sorted((i1, i2)->i1.getEmpGender().compareTo(i2.getEmpGender()))
			.collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.counting()))
			.forEach((x, y)->{
				System.out.println(x+" Employees Count : "+y);
			});
		System.out.println("/******** "+genderLabel+" *********/");
		
		System.out.println();
		
		// Employees Avg salary by Gender 
		String genderAvgSalLabel = "Employees Avg salary by Gender";
		System.out.println("/******** "+genderAvgSalLabel+" *********/");
			empDet.stream()
				.distinct()
				.collect(Collectors.groupingBy(EmployeeExt::getEmpGender, Collectors.averagingDouble(EmployeeExt::geteSal)))
				.forEach((x, y)->{
					System.out.println(x+" Employees Avg Salary : "+y);
				});		
		System.out.println("/******** "+genderAvgSalLabel+" *********/");
		
		System.out.println();
		
		//find the employee in each branch who‘s is salary greater than 10000
		String deptWiseSalGrt10K = "Employees in each branch who‘s is salary greater than 10000";
		int salary = 50000;
		System.out.println("/******** "+deptWiseSalGrt10K+" *********/");
		 empDet.stream()
		 	.collect(Collectors.groupingBy(Employee::getDepartment))
		 	.forEach((k,v)->{
		 		//key
		 		System.out.println("\n"+k+" Department");

		 		//value 
		 		v.stream()
		 			.filter(s->s.geteSal()>salary)
		 			.sorted((a,b)->a.getfName().compareTo(b.getfName()))
		 			.collect(Collectors.toList())
		 			.forEach(i->System.out.println(i.toStringSpecific()));
		 	});
		 System.out.println();
		 System.out.println("/******** "+deptWiseSalGrt10K+" *********/");
	} //psvm

}
