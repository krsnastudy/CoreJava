package com.prac.core.jdk8.stream.employee.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulateEmpData {

//	public static int recordsCount;
	
	public PopulateEmpData() {
	}

	public static ArrayList<Employee> populateEmpData(int recordsCount) {

		Random rSal = new Random();
		Random rPC = new Random();
		Random rEno = new Random();

		List<Employee> eList = new ArrayList<Employee>();

		for (int i = 0; i < recordsCount; i++) {
			Employee e = new Employee(randomString(10), 
									  randomString(5), 
									  rEno.nextInt(999999),//i, 
									  (rSal.nextFloat() * 100000),
									  rPC.nextInt(999999),
									  Department.getRandomDepartment());
			eList.add(e);

			// Duplicating Records
			if(i%2==0){ eList.add(eList.get(i)); }
			 
		}

		// System.out.println("Raw Data :"+eList.size());
//		 eList.stream().forEach(x->System.out.println(x.toString()));

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
		
		// get First letter of the string
        String firstLetStr = generatedString.substring(0, 1);
        // Get remaining letter using substring
        String remLetStr = generatedString.substring(1);
 
        // convert the first letter of String to uppercase
        firstLetStr = firstLetStr.toUpperCase();
 
        // concantenate the first letter and remaining string
        generatedString = firstLetStr + remLetStr;
		
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