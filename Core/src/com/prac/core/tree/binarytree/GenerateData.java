package com.prac.core.tree.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateData {

	public static String getRandomString(int size) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = size;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    generatedString = initCap(generatedString);
	    //System.out.println(generatedString);
	    return generatedString;
	}
	
	public static String initCap(String str) {
		
		String capitalizeWord="";  
		String first=str.substring(0,1);  
        String afterfirst=str.substring(1);  
        //System.out.println(first);
        //System.out.println(afterfirst);
        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        
        return capitalizeWord;
	}

	public static Map<Integer, Employee> createEmployee(int size) {
		
		Map<Integer, Employee> eMap = new HashMap<>();
		
		int eno=1000; 
		
		for(int i=1; i<=size;i++) {
			String fName= getRandomString(10).trim();
			String lName= getRandomString(2).trim();
			String eMail = fName.substring(0,3)+"."+lName+"@eMail.com"; 
			Address addr = new Address(getRandomString(5).trim(), getRandomString(5).trim(), getRandomString(5).trim(), new Random().nextInt());
			int id = i+new Random().nextInt(999);
			
			Employee e = new Employee(id, 
					              fName, 
					              lName, 
					              (new Random().nextLong()), 
					              getRandomString(5), 
					              (new Random().nextLong()*eno)+i, 
					              eMail.trim(), 
					              addr);
		
			eMap.put(id, e);
			/*
			 * String lastName = getRandomString(2); if((id%2)==0) { eMap.put((id), new
			 * Employee(e, lastName)); }else{ eMap.put((id), e); }
			 */
		}
	
		return eMap;
	}
	
} //GenerateData
