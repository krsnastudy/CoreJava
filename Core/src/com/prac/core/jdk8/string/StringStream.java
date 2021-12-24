package com.prac.core.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StringStream {

	public static void main(String[] args) {
		String str = "Simply put, a facade encapsulates a complex subsystem behind a simple interface. It hides much of the complexity and makes the subsystem easy to use. Also, if we need to use the complex subsystem directly, we still can do that; we aren't forced to use the facade all the time. Besides a much simpler interface, there's one more benefit of using this design pattern. It decouples a client implementation from the complex subsystem. Thanks to this, we can make changes to the existing subsystem and don't affect a client. Let's see the facade in action.";

		String[] sArr = str.split(" ");
		Map<String, Long> cnt = Arrays.stream(sArr).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		Map<String, Long> cnt1 = cnt.entrySet().stream().filter(x -> x.getValue() > 1)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

//		cnt1.forEach((x,y)->System.out.println(x +" -- "+y));

		System.out.println("Words with count");
		Map<String, Long> cnt2 = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).collect(Collectors.toMap(x -> x.getKey(), y -> y.getValue()))
//		.forEach((x,y)->System.out.println(x +" -- "+y));
		;

		cnt2.forEach((x, y) -> System.out.println(x + " -- " + y));

		System.out.println(
				"\nMax Count: " + cnt2.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get());
	}
}