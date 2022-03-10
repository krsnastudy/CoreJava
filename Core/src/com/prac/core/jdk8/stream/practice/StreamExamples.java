package com.prac.core.jdk8.stream.practice;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		List<Employee> empData = EmployeeData.getEmpData();
		
		//How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees=empData.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("noOfMaleAndFemaleEmployees: "+noOfMaleAndFemaleEmployees);
		
		//Print the name of all departments in the organization?
		System.out.println("\nAll Departments in the Organization: ");
		empData.stream().map(Employee::getDepartment).distinct().sorted().forEach(i->System.out.println(i));
		
		// What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
				empData.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("\navgAgeOfMaleAndFemaleEmployees: "+avgAgeOfMaleAndFemaleEmployees);
		
		//Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployeeWrapper =
				empData.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("\nhighestPaidEmployeeWrapper: "+highestPaidEmployeeWrapper.get());
		
		//Get the details of highest paid employee in the organization Dept wise?
		System.out.println("\n<<< Departmentwise Highest Salary Paid >>>");
				empData.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment))
				.forEach((k,v)->{
					System.out.println("Department: "+k+" --> "
								+v.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get());
				});
	
		//Count the number of employees in each department?
		System.out.println("\n<<< Departmentwise Employees Count >>>");
				empData.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				.forEach((x,y)->System.out.println(x+" has "+y+" Employees"));
				
		//What is the average salary of each department?
		System.out.println("\n<<< Average salary of each department >>>");		
			empData.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.forEach((x,y)->System.out.println(x+" : "+y));
			
		//Get the details of youngest male employee in the product development department?	
		System.out.println("\n<<< youngest male employee in the product development department >>>");			
		Employee youngestMaleEmployee = 
				empData.stream()
				.filter(i->i.getDepartment().equalsIgnoreCase("Product Development"))
				.filter(i->i.getGender().equalsIgnoreCase("Male"))
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)))
				.get();
		System.out.println(youngestMaleEmployee);
		
		//Who has the most working experience in the organization
		System.out.println("\n<<< most working experience in the organization >>>");
		Employee seniorMostEmployeeWrapper = empData.stream()
				.sorted(Comparator.comparing(Employee::getYearOfJoining))
				.findFirst()
				.get();
		System.out.println(seniorMostEmployeeWrapper);
		
		//How many male and female employees are there in the sales and marketing team?
		System.out.println("\n<<< How many male and female employees are there in the sales and marketing team >>>");
			empData.stream()
				.filter(i->i.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
				.forEach((x, y)->System.out.println(x+" "+y));
				;
		//What is the average salary of male and female employees?
		System.out.println("\n<<< average salary of male and female employees >>>");				
			empData.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
				.forEach((x, y)->System.out.println(x+" "+y));
				;
		//List down the names of all employees in each department
		System.out.println("\n<<< names of all employees in each department >>>");		
			empData.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment))
				.forEach((x,y)->{
					System.out.println(
							x+" --> "+
							 y.stream().map(m->m.getName()).collect(Collectors.joining(", "))
							);
				});
				;
				
	    //What is the average salary and total salary of the whole organization?
		System.out.println("\n<<< average salary and total salary of the whole organization >>>");
			DoubleSummaryStatistics doubleSummary = empData.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary))
				;
		System.out.println(doubleSummary);
		System.out.println("Average Salary = "+doubleSummary.getAverage());
		System.out.println("Total Salary = "+doubleSummary.getSum());
		
		//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		System.out.println("\n<<< employees who are younger or equal to 25 years from those employees who are older than 25 years >>>");
		
			Map<Boolean, List<Employee>> ageMap = 
					empData.stream()
						.collect(Collectors.partitioningBy(e->e.getAge()>25));
//			System.out.println(ageMap);
			ageMap.entrySet().stream()
				.forEach(i->{
					if(i.getKey()) {
						System.out.println("Employees Age >25 Yrs : "+i.getValue().stream().map(k->k.getName()).collect(Collectors.joining(", ")));
					}else {
						System.out.println("Employees Age <25 Yrs : "+i.getValue().stream().map(k->k.getName()).collect(Collectors.joining(", ")));	
					}
				});
			
		//Who is the oldest employee in the organization? What is his age and which department he belongs to?
		System.out.println("\n<<< oldest employee in the organization? What is his age and which department he belongs to >>>");
//			Optional<Employee> oldestEmployee = empData.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
		Optional<Employee> oldestEmployee = empData.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println(oldestEmployee.get());
	} //psvm
}
