package com.prac.core.jdk8.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.prac.core.jdk8.util.CoreUtil;

public class MapAndFlatMap {

	public static void main(String[] args) {

//		List<String> namesMap = Arrays.asList("Saket", "Trevor", "Franklin", "Michael");
		List<String> namesMap = CoreUtil.getRandomNames(5, 10);
		List<String> namesMapUpper = namesMap.stream().map(String::toUpperCase).collect(Collectors.toList());
		
//		System.out.println("Map Example: " + namesMapUpper);
		System.out.print("Map Example: ");
		namesMapUpper.forEach(i -> System.out.print(i + " "));

		List<List<String>> namesFlat = Arrays.asList(Arrays.asList("Saket", "Trevor"), Arrays.asList("John", "Michael"),
				Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));

		List<String> namesFlatMap = namesFlat.stream()
				.flatMap(x -> x.stream().map(y -> y.toUpperCase()).filter(z->z.startsWith("S")))
				.collect(Collectors.toList());
		
//		System.out.println("FlatMap Example: " + namesFlatMap);
		System.out.print("\nFlatMap Example: ");
		namesFlatMap.forEach(i -> System.out.print(i + " "));
		
		
		List<List<String>> namesFlat1 = new ArrayList<List<String>>();
			namesFlat1.add(CoreUtil.getRandomNames(5, 15));
			namesFlat1.add(CoreUtil.getRandomNames(8, 4));
			namesFlat1.add(CoreUtil.getRandomNames(10, 5));
			namesFlat1.add(CoreUtil.getRandomNames(18, 8));
			namesFlat1.add(CoreUtil.getRandomNames(12, 6));
			namesFlat1.add(CoreUtil.getRandomNames(14, 3));
			namesFlat1.add(CoreUtil.getRandomNames(9, 7));
		
		List<String> namesFlatMap1 = namesFlat1.stream().flatMap(fMap -> fMap.stream()).collect(Collectors.toList());
		System.out.println("\nFlatMap Example: " + namesFlatMap1);
	}

}
