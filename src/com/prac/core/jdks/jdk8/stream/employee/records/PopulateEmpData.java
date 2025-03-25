package com.prac.core.jdks.jdk8.stream.employee.records;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PopulateEmpData {

//	public static int recordsCount;

	public PopulateEmpData() {
	}

	public static ArrayList<Employee> populateEmpData(int recordsCount) {

		Random rSal = new Random();
		Random rPC = new Random();
		Random rEno = new Random();
		int minEno = 100000;
		int maxEno = 9999999;
		int minPin = 500000;
		int maxPin = 999999;
		int minAge = 18, maxAge = 100;
		Random rAge = new Random();
/*	
	List<Employee> eList = new ArrayList<Employee>();
	
// Traditional Way
		for (int i = 0; i < recordsCount; i++) {
			Employee e = new Employee(
					randomString(10), 
					randomString(5),
					// rEno.nextInt(999999),//i,
					rEno.ints(minEno, maxEno).findFirst().getAsInt(), 
					(rSal.nextFloat() * 100000),
//					rPC.nextInt(999999),
					rPC.ints(minPin, maxPin).findFirst().getAsInt(), 
					Department.getRandomDepartment()
				);

			eList.add(e);

			// Duplicating Records
			if (i % 2 == 0) {
				eList.add(eList.get(i));
			}
		}//for Loop

		return (ArrayList<Employee>) eList;
 
*/		
		// Using Functional Programming		
		return (ArrayList<Employee>) IntStream.rangeClosed(1, recordsCount)
				.mapToObj(i->
						new Employee(randomString(10),
							randomString(5),
							rEno.ints(minEno, maxEno).findFirst().getAsInt(), 
							(rSal.nextFloat() * 100000),
							rPC.ints(minPin, maxPin).findFirst().getAsInt(),
							Department.getRandomDepartment().toString(),
							rAge.ints(minAge, maxAge).findFirst().getAsInt(),
							Gender.getRandomGender().toString()
								)
						)
				.collect(Collectors.toList())
				;

		// System.out.println("Raw Data :"+eList.size());
//		 eList.stream().forEach(x->System.out.println(x.toString()));


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

}//main
