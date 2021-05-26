package com.prac.core.jdk5.string;

import java.util.Optional;

public class OptionalBasicExample {

    public static void main(String[] args) {

    	String[] str = new String[10];  
    	str[5] = "JAVA OPTIONAL CLASS EXAMPLE";
    	Optional<String> checknull = Optional.ofNullable(str[5]);
    	
        if(checknull.isPresent()){  // It Checks, value is present or not  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("String value is not present");  
    }

}
