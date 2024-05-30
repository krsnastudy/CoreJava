package com.prac.core.jdk8.optional;

import java.util.OptionalInt;

public class OptionalfPresent {

	public static void main(String[] args) {

		// create a OptionalInt
//        OptionalInt opint = OptionalInt.empty();
		 OptionalInt opint = OptionalInt.of(2234);
 
        // apply ifPresent(IntConsumer)
        opint.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification:=> " + value);        
            
        });
 
        System.out.println("As OptionalInt is empty value"+ " is not modified");		

	}

}
