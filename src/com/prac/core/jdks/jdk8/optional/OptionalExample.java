package com.prac.core.jdks.jdk8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OptionalExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11);

		Optional<Object> o = Optional
				.of(list.stream().filter(x -> x % 2 == 0).max((a, b) -> Integer.compare(a, b)).orElse(0));
		System.out.println("Max Even Integer: " + o.get());

		System.out.println(list.stream().filter(x -> x % 2 == 0).max((a, b) -> Integer.compare(a, b)).orElse(0));

		Optional<String> nonEmptyOptional = Optional.of("Vishwa Ratna");
		String value = nonEmptyOptional.orElse(iAmStillExecuted());

		String mayBeNull = "null"; // "null" // "Test"
		Optional<String> optOrElse = Optional.of(Optional.ofNullable(mayBeNull).orElse("orElse"));
		System.out.println("orElse() : " + optOrElse.get());

		// setting default value using lambda function inside orElseGet
		Optional<String> optOrElseGet = Optional.of(Optional.ofNullable(mayBeNull).orElseGet(() -> "orElseGet"));
		System.out.println("orElseGet() : " + optOrElseGet.get());
		
		/********* orElse() *******/
		System.out.println("/***** orElse() **********/");
		String name = Optional.of("baeldung")
				  .orElse(getRandomName());
	}

	public static String iAmStillExecuted() {
		System.out.println("nonEmptyOptional is not NULL, still I am being executed");
		return "I got executed";
	}
	
	public static String getRandomName() {
		System.out.println("getRandomName() method - start");
	    
	    Random random = new Random();
	    int index = random.nextInt(5);
	    
	    System.out.println("getRandomName() method - end");
	    return index+"";
	}

}
