package com.prac.core.jdks.jdk5.gen;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {

		Random random = new Random();
		int range = 100;
		int min = 101;
		int max = 200;

		for (int i = 0; i < 100; i++) {
			System.out.print("Iteration: " + i + " --> ");
			System.out.print("nextInt: " + random.nextInt(range) + " ");
			System.out.println("ints: " + random.ints(min, max).findFirst().getAsInt());
		}
	}
}
