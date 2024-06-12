package com.prac.core.jdk8.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.prac.core.jdk8.util.CoreUtil;

public class MapAndFlatMap {

	public static void main(String[] args) {
		List<String> namesMap = CoreUtil.getRandomNames(5, 10);
		List<String> namesMapUpper = namesMap.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
		
		System.out.print("Map Example: ");
		namesMapUpper.forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Joining  Ex: "+namesMapUpper.stream().map(String::valueOf).collect(Collectors.joining(", ")));

		List<List<String>> namesFlat = Arrays.asList(
											Arrays.asList("Saket", "Trevor", "Zian"), 
											Arrays.asList("John", "Michael", "Adrian"),
											Arrays.asList("Shawn", "Franklin", "Scarsbrook"), 
											Arrays.asList("Johnty", "Sean"));

		List<String> namesFlatMap = namesFlat.stream()
				.flatMap(x -> x.stream().map(y -> y.toUpperCase())
				.filter(z->z.startsWith("S")))
				.sorted()
				.collect(Collectors.toList());
		
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

		List<String> namesFlatMap1 = namesFlat1.stream()
				.flatMap(fMap -> fMap.stream())
				.sorted() //Alphabetical Order Sorting
//				.sorted(Collections.reverseOrder()) // Reverse Order Sorting
				.collect(Collectors.toList())
				;
		System.out.println("\nFlatMap Example: " + namesFlatMap1+"\n");

		List<List<String>> namesFlat2 = new ArrayList<List<String>>();
		IntStream.range(1 , 100)
				.mapToObj(x -> namesFlat2.add(CoreUtil.getRandomNames(CoreUtil.getRandomNumber(), CoreUtil.getRandomNumber())))
				.collect(Collectors.toList());

		System.out.println("Original namesFlat2: "+namesFlat2);

		List<String> namesFlatMap2 = namesFlat2.stream()
				.flatMap(f->f.stream())
//				.sorted()
				.sorted(Comparator.reverseOrder())
				.filter(s->s.startsWith("K"))
				.collect(Collectors.toList())
				;

		System.out.println("FlatMap2: "+namesFlatMap2);
	}
}