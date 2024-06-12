package com.prac.core.jdk8.arrlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.prac.core.jdk8.util.CoreUtil;

public class Counting {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("Krishna");
		list1.add("Radha");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("Radha");
		list1.add("Krishna");

		Map<Object, Long> counters = list1.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(counters);

		Optional<Entry<Integer, Long>> ent = CoreUtil.getRandomNumbers(10).stream()
			.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
			.entrySet().stream()
			.filter(m->m.getValue()==1L)
			.findFirst()
		;
		
		System.out.println(ent);
		
	}
}
