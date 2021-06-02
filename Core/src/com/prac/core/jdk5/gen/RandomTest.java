package com.prac.core.jdk5.gen;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		Random random =  new Random();
		int range=4; int min=1; int max=10;
		
		for(int i=0; i<100; i++) {
			System.out.print("Iteration: "+i+" --> ");
			System.out.print("nextInt: "+random.nextInt(range)+" ");
			System.out.println("ints: "+random.ints(min, max).findFirst().getAsInt());
		}
		
	}

}
