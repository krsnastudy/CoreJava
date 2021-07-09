package com.prac.core.jdk8.predefinedfunctions.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;
import com.prac.core.jdk8.stream.employee.data.PopulateEmpData;

public class ConsumerExample {

	public static void main(String[] args) {
//		Consumer<String> c = x->System.out.println(x);
		Consumer<String> c = System.out::println;
//		c.accept("RK");

		List<Employee> empData = new ArrayList<Employee>();
		int noOfRecords = 10; // How many records you want
		empData = PopulateEmpData.populateEmpData(noOfRecords);

		Consumer<List<Employee>> consumer = emp -> emp.stream().distinct()
				.forEach(x -> System.out.println(x.toString()));

		List<Employee> filterData = empData.stream().distinct().filter(e -> e.geteSal() > 80000)
				.collect(Collectors.toList());

		System.out.println("\nConsumer accept() RawData");
		consumer.accept(empData);

		System.out.println("\nConsumer accept() FilteredData");
		consumer.accept(filterData);

		Consumer<List<Employee>> chained1 = chain -> chain.stream().distinct()
//				.filter(s -> s.getDepartment().equals("IT"))
				.filter(s -> s.geteSal() > 90000)
				.forEach(x -> System.out.println(x.toString()));

		Consumer<List<Employee>> chained2 = chain -> chain.stream().distinct()
//				.filter(s -> s.getDepartment().equals("Admin"))
				.filter(y->y.getfName().contains("s"))
				.forEach(x -> System.out.println(x.toString()));

		Consumer<List<Employee>> chainedCosumer = chained1.andThen(chained2);

		System.out.println("\nConsumer accept() ChainingData");
		chained1.accept(empData);
		chainedCosumer.accept(empData);

	}
}

/*
It is a functional interface defined in java.util.function package.
It contains an abstract accept() and a default andThen() method. 
It can be used as the assignment target for a lambda expression or method reference.
The Consumer Interface accepts a single argument and does not return any result.

void accept(T t) --> It performs this operation on the given argument.

default Consumer<T> andThen(Consumer<? super T> after) --> 
It returns a composed Consumer that performs, in sequence, this operation followed by the after operation. 
If performing either operation throws an exception, it is relayed to the caller of the composed operation. 
If performing this operation throws an exception, the after operation will not be performed.

*/