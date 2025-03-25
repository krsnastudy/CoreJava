package com.prac.core.jdks.jdk8.optional;

import java.util.OptionalInt;
import java.util.Random;

public class OptionalfPresent {

	public static void main(String[] args) {

		// create a OptionalInt
//        OptionalInt opint = OptionalInt.empty();
		 OptionalInt opint = OptionalInt.of(new Random().nextInt(10, 9999));
 
        // apply ifPresent(IntConsumer)
        opint.ifPresent((value) -> {
            int multiplier = new Random().nextInt(2, 9);
            System.out.println("Value Before, Multiplier:=> " + value+", "+multiplier);

            value = value * multiplier;
            System.out.println("Value After Modification:=> " + value);
        });
 
//        System.out.println("As OptionalInt is empty value"+ " is not modified");

	}

}
