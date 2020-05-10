package com.prac.core.string.empl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RemoveDupEmp {

	public static void main(String[] args) {
		ArrayList<Employee> eData = populateEmpData();

		List<Employee> fData = eData.stream().distinct().collect(Collectors.toList());

		// System.out.println("\nFiltered Data Java8:"+fData.size());
		fData.forEach(x -> System.out.println(x.toString()));
		
/*		
		// Salary Group By
		fData = changeData(fData, "sal");
		fData.forEach(x -> System.out.println(x.toString()));
		
		Map<Float, Long> sData = fData.stream().collect(
				Collectors.groupingBy(Employee::geteSal, Collectors.counting()));
		sData.forEach((k,v)->System.out.println("Salary: "+k+" & Count: "+v));
		
		// Pin Group By
		fData = changeData(fData, "pin");
		fData.forEach(x -> System.out.println(x.toString()));
		
		Map<Integer, Long> pData = fData.stream().collect(
				Collectors.groupingBy(Employee::getePincode, Collectors.counting())
				);
		pData.forEach((k,v)->System.out.println("Pincode: "+k+" & Count: "+v));
*/		
		// Removing Duplicates; legacy code
		/*
		 * Set<Employee> s= new HashSet<Employee>(); ArrayList<Employee> list = new
		 * ArrayList<Employee>(); s.addAll(eData); list.addAll(s);
		 * System.out.println("\nFiltered Data Legacy:"+list.size());
		 * list.forEach(x->System.out.println(x.toString()));
		 */

		/*
		 * // Shallow & Deep Cloning ArrayList<Employee> list1 = new
		 * ArrayList<Employee>(list); // Shallow Copy ArrayList<Employee> list2 = new
		 * ArrayList<Employee>(); // Deep Copy
		 * 
		 * System.out.println("\n Copy Data:"+list1.size());
		 * list1.forEach(x->System.out.println(x.toString()));
		 * 
		 * for (Employee employee : list) { list2.add(new Employee(employee)); // Deep
		 * Copy }
		 * 
		 * // Modification 1 list1.get(0).setlName("RK");
		 * 
		 * System.out.println("\nModified Data :");
		 * list.forEach(x->System.out.println(x.toString())); System.out.println();
		 * list1.forEach(x->System.out.println(x.toString())); System.out.println();
		 * list2.forEach(x->System.out.println(x.toString()));
		 */
	}

	public static ArrayList<Employee> populateEmpData() {

		Random rSal = new Random();
		Random rPC = new Random();

		List<Employee> eList = new ArrayList<Employee>();

		for (int i = 0; i < 5; i++) {
			Employee e = new Employee(randomString(10), randomString(5), i, (rSal.nextFloat() * 100000),
					rPC.nextInt(999999));
			eList.add(e);
			
			if(i%2==0){ eList.add(eList.get(i)); }
			 
		}

		// System.out.println("Raw Data :"+eList.size());
		// eList.stream().forEach(x->System.out.println(x.toString()));

		return (ArrayList<Employee>) eList;
	}

	public static String randomString(int length) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = length;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		// System.out.println(generatedString);
		return generatedString;
	}

	public static ArrayList<Employee> changeData(List<Employee> eData, String type){
	
		for(int i=0; i<eData.size();i++) {
			Employee e = new Employee();
			e = eData.get(i);
			
			if(type.equalsIgnoreCase("sal")) {
				int diff = 100000; float amt = 0;
				if(i%2==0) {
					amt = e.geteSal()+(diff-e.geteSal());	
				}else {
					amt = e.geteSal()+((2*diff)-e.geteSal());
				}
				e.seteSal(amt);
			}
			
			if(type.equalsIgnoreCase("pin")) {
				int diff = 999999; int set = 0;
				if(i%2==0) {
					set = e.getePincode()+(diff-e.getePincode());	
				}else {
					set = e.getePincode()+((2*diff)-e.getePincode());
				}
				e.setePincode(set);
			}
		}
		
		return (ArrayList<Employee>) eData;
	}
	
}
