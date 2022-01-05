package com.prac.core.jdk8.stream.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class EmployeeStream {

	public static void main(String[] args) {
		int noOfRecords = 20; // How many records you want
		List<Employee> emp = new ArrayList<Employee>();
		PopulateEmpData exec = new PopulateEmpData();
		emp = exec.populateEmpData(noOfRecords);

		// Original Data contains duplicates
//		System.out.println("<<< Original Data >>>");
//		emp.forEach(System.out::println);

		HashSet hSet = new HashSet<>(emp);

		/* Adding List to HashMap */
		Map<Object, Object> hMap = emp.stream().distinct()
//					.collect(Collectors.toMap(Employee::geteNumber, v->v))
				.collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (x, y) -> x, HashMap::new));
//		System.out.println(hMap);

		System.out.println("Orig Data Size: " + emp.size() + " && HashSet Size: " + hSet.size() + " && TreeMap Size: ");

		/* Adding List to TreeMap */
		Map<Integer, Employee> tMap = emp.stream()// .distinct()
				.collect(Collectors.toMap(Employee::geteNumber, Function.identity(), (e1, e2) -> e1, TreeMap::new));

		System.out.println(tMap);

		/* Adding List to TreeMap */
		Map<Integer, Object> LinkedHashMap = emp.stream().collect(
				Collectors.toMap(Employee::geteNumber, Function.identity(), (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("\n<<< Distinct Employees Data >>>");
		ArrayList<Employee> empDistinct = (ArrayList<Employee>) emp.stream().distinct().collect(Collectors.toList());
//		   .forEach(System.out::println);

		empDistinct.forEach(e -> System.out.println(e.geteNumber() + " - " + e.getfName() + ", " + e.getlName() + ", "
				+ e.geteSal() + ", " + e.getDepartment()));
//		empDistinct.forEach(e->System.out.println(e.toStringSpecific()));

		System.out.println("\n<<< Employees FirstName with S >>>");
		empDistinct.stream().filter(x -> x.getfName().startsWith("S")).collect(Collectors.toList())
				.forEach(x -> System.out.println(x.geteNumber() + " - " + x.getfName()));

		System.out.println("\n<<< Employees Salary > 50000 >>>");
		ArrayList<Employee> eList = (ArrayList<Employee>) empDistinct.stream().filter(x -> x.geteSal() > 50000)
				.collect(Collectors.toList());
//		   .forEach(System.out::println);

		Optional<ArrayList<Employee>> opt = Optional.ofNullable(eList);
//		opt.ifPresent(System.out::println);
//		opt.ifPresent(x-> {x.forEach((y)->{System.out.println();});});
		opt.ifPresent(x -> {
			x.forEach((y) -> {
				System.out.println("EmpNo: " + y.geteNumber() + " - " + y.geteSal());
			});
		});

		// If a value is present, performs the given action with the value,otherwise
		// performs the given empty-based action.
		/*
		 * opt.ifPresentOrElse( (e)->{System.out.println("Present");},
		 * ()->{System.out.println("Not Present");} );
		 */

		ArrayList<String> eNamesList = (ArrayList<String>) empDistinct.stream().filter(x -> x.geteSal() > 50000)
				.map(x -> x.getfName()).collect(Collectors.toList());

		System.out.println("\nNamesList: " + eNamesList);

		// Sorting By firstName, lastName, Department
		System.out.println("\n<<< Sorting Employees by firstName, lastName >>>");
		Comparator<Employee> empComparator = Comparator
//				.comparing(Employee::geteNumber).reversed()
				.comparing(Employee::getfName)
				.thenComparing(Employee::getlName)
//				.thenComparing(Employee::getDepartment)
//				.thenComparing(Employee::geteNumber)
				.reversed();

		ArrayList<Employee> sorted = 
				(ArrayList<Employee>) empDistinct.stream()
												 .sorted(empComparator)
												 .collect(Collectors.toList());

		sorted.forEach(e -> System.out.println(e.geteNumber() + " - " + e.getfName() + ", " + e.getlName()));

		System.out.println("\n<<< Employees By Department >>>");
		Map<DepartmentCode, List<Employee>> dept = empDistinct.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		dept.forEach((k, v) -> System.out.println(k + " Department" + " --> " +
		// v
				((List<Employee>) v).stream().map(m -> m.getfName() + "[" + m.geteNumber() + "]")
						.collect(Collectors.joining(", "))));

		System.out.println("\n<<< Departmentwise Salary Summation >>>");
		dept.forEach((k, v) -> System.out.println(k + " Department" + " --> " +
		// v
				((List<Employee>) v).stream().collect(Collectors.summingDouble(Employee::geteSal))));

		System.out.println("\n<<< Highest Salary Paid >>>");
		Optional<Employee> empHighSal = empDistinct.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::geteSal)));

//		System.out.println(empHighSal.isPresent()? (empHighSal.get().geteNumber()+" "+empHighSal.get().geteSal()):"Not Available");
		System.out.println(empHighSal.isPresent() ? empHighSal.get() : "Not Available");

		System.out.println("\n<<< Lowest Salary Paid >>>");
		Optional<Employee> empMinSal = empDistinct.stream()
				.collect(Collectors.minBy(Comparator.comparing(Employee::geteSal)));

		System.out.println(empMinSal.isPresent() ? empMinSal.get() : "Not Available");

		Map<DepartmentCode, List<Employee>> deptSal = empDistinct.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println("\n<<< Departmentwise Highest Salary Paid >>>");
		dept.forEach((k, v) -> {
			System.out.println(k + " Department: " +
			// v
			v.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::geteSal))).get().toStringSpecific());
		});

	}
}

/*
 * 
 * // Sorting By fName, lName, Dept ArrayList<Employee> sorted =
 * (ArrayList<Employee>) empDistinct.stream() .sorted(new Comparator<Employee>()
 * {
 * 
 * @Override public int compare(Employee o1, Employee o2) {
 * if((o1.getfName().compareTo(o2.getlName())>1)) { return
 * o1.getfName().compareTo(o2.getfName()); }else { return
 * o1.getlName().compareTo(o2.getlName()); } }
 * 
 * }).collect(Collectors.toList());
 * 
 * 
 * 
 * 
 */
