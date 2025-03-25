package com.prac.core.jdks.jdk8.fi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayListSorting {

	public static void main(String[] args) {

		List<Person> list = Arrays.asList(new Person("Anand", "Birla", 25, "Delhi"),
				new Person("Cath", "Demi", 21, "Bangalore"), new Person("Erek", "Huel", 15, "Bangalore"),
				new Person("Jakub", "Lisa", 36, "Hyderabad"), new Person("Morison", "Nurea", 12, "Hyderabad"));

		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

//		list.stream().forEach(x->System.out.println(x));
//		list.stream().forEach(System.out::println);
		printConditionally(list, p -> true, System.out::println);

		System.out.println();
		printConditionally(list, p -> p.getLastName().startsWith("L"),
				p -> System.out.println("getLastName: " + p.getLastName()));

		System.out.println();
		printConditionally(list, p -> p.getFirstName().startsWith("A"),
				p -> System.out.println("getFirstName: " + p.getFirstName()));

		System.out.println();
		printConditionally(list, p -> p.getAge() > 20, p -> System.out.println(p.getFirstName() + "-" + p.getAge()));

		System.out.println();
		printConditionally(list, p -> p.getLocation().endsWith("e"), System.out::println);

//		System.out.println(list.stream().anyMatch(e->e.getLastName().startsWith("L")));

	}

	private static void printConditionally(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : list) {
			if (predicate.test(p)) {
				// System.out.println(p);
				consumer.accept(p);
			}
		}
	}

}
