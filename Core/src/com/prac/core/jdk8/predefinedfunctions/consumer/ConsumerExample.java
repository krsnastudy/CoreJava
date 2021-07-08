package com.prac.core.jdk8.predefinedfunctions.consumer;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
//		Consumer<String> c = x->System.out.println(x);
		Consumer<String> c = System.out::println;
		c.accept("RK");
	}

}
