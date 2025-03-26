package com.prac.core.jdks.jdk5.clone;

//Java program to illustrate the difference between shallow
//and deep copy
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CloneExample {
	public static void main(String[] args) {
		// Create a Honda car object
		ArrayList<String> hondaColors = new ArrayList<>();
		hondaColors.add("Red");
		hondaColors.add("Blue");
		Car honda = new Car("Honda", hondaColors);

		// Deep copy of Honda
		Car deepcopyHonda = new Car(honda.name, new ArrayList<>(honda.colors));
		deepcopyHonda.colors.add("Green");
		
		System.out.print("Deep Copy: "+deepcopyHonda.colors.stream().collect(Collectors.joining(", ")));
		System.out.println("\nOriginal: "+honda.colors.stream().collect(Collectors.joining(", ")));
		
		System.out.println("/*****************/");

		// Shallow Copy of Honda
		Car copyHonda = honda;
		copyHonda.colors.add("Green");

		System.out.print("Shallow Copy: "+copyHonda.colors.stream().collect(Collectors.joining(", ")));
		System.out.println("\nOriginal: "+honda.colors.stream().collect(Collectors.joining(", ")));
		
		System.out.println();
	}
}
