package com.prac.core.jdk8.stream.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdk8.stream.employee.data.Gender.GenderCode;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class StreamPractice {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {
		int noOfRecords = 50; // How many records you want
		List<Employee> employeeList = new ArrayList<Employee>();
		PopulateEmpData populate = new PopulateEmpData();
		employeeList = populate.populateEmpData(noOfRecords);
//		System.out.println("Given Data"+employeeList);
		Comparator<Employee> salaryDesc = Comparator.comparing(Employee::geteSal).reversed();
		
//		employeeList.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
//		employeeList.stream().sorted((i1, i2)->i2.geteSal()-i1.geteSal()).forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
//		Type mismatch: cannot convert from float to int
		
		//Highest Salary
		Employee highestSal = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::geteSal))).get();
		System.out.println("Highest Salaried Employee: "+highestSal);
		
		//Lowest Salary
		Employee lowestSalary = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::geteSal))).get();
		System.out.println("Lowest Salaried Employee: "+lowestSalary);
		
		int rank=2;
		Employee nthHighestSal = employeeList.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).collect(Collectors.toList()).get(rank-1);
		System.out.println("["+rank+"] Highest Salary: "+nthHighestSal+"\n");
		
		System.out.println("/**************** "+rank+" Highest Salary Each Departmentwise *************/");
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.forEach((x,y)->{
				System.out.print("Department: "+x);
				System.out.print(y.stream().sorted(salaryDesc).collect(Collectors.toList()).get(rank-1).toString()+"\n");
			});
		System.out.println();
		
		
		/****** Extra Details *********/
		List<EmployeeExt> empDet = new ArrayList<EmployeeExt>();
		empDet = populate.populateEmployeeMoreDetails(150);
		empDet.stream().sorted(Comparator.comparing(Employee::geteSal).reversed()).forEach(i->System.out.print(i.geteNumber()+"["+i.geteSal()+"], "));
		
		/**** Sum of Salary *****/
		Double sal = empDet.stream().filter(i->i.getEmpAge()<30).collect(Collectors.summingDouble(EmployeeExt::geteSal));
		System.out.println("\nTotal Salary: "+sal);
		
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
		int salary = 75000;
		String deptWiseSalGrt10K = "Employees in each branch who‘s is salary greater than "+salary;
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
		 
		 empDet.stream()
		 	.collect(Collectors.groupingBy(EmployeeExt::getEmpGender))
		 	.forEach((x,y)->{
		 		System.out.println(x+" Department Emp Names: "
		 			+ y.stream().map(i->"["+i.getfName()+" "+i.getlName()+"]").collect(Collectors.joining(", "))	
		 				);
		 	});
		 
		 System.out.println();
		 System.out.println("/******** Convert List to Map *********/");		 
		 Map<Integer, EmployeeExt> eMap =
				 empDet.stream()
				 	.sorted((i1, i2)->i1.geteNumber()-i2.geteNumber())
				 	.collect(Collectors.toMap(
						 	EmployeeExt::geteNumber, 
						 	Function.identity(), 
						 	(e1, e2)->e1, 
						 	LinkedHashMap::new)
						 )
				 	;
		 
		 //eMap.entrySet().stream().forEach(System.out::println);
		 System.out.println("/******** Convert List to Map *********/");
		 
		 System.out.println("\n/******** Sum of Salary *********/");
		 	
		 	Double bySummingDouble = empDet.stream().collect(Collectors.summingDouble(EmployeeExt::geteSal));
		 	Double byReduceFunc = empDet.stream().mapToDouble(EmployeeExt::geteSal).reduce(0, (s1, s2)->s1+s2);
		 	Double bySummarizingDouble = empDet.stream().collect(Collectors.summarizingDouble(EmployeeExt::geteSal)).getSum();
		 	
		 System.out.println("     bySummingDouble: "+bySummingDouble
				 +"\n\tbyReduceFunc: " +byReduceFunc
				 +"\n bySummarizingDouble: "+bySummarizingDouble);	
		 	
		 System.out.println("/******** Sum of Salary *********/");
		 
	} //psvm

}

/**
*
https://medium.com/@veenaraofr/java8-stream-api-commonly-asked-questions-about-employee-highest-salary-99c21cec4d98
*
* */