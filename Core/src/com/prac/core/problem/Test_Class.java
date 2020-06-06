package com.prac.core.problem;

import java.util.Arrays;

public class Test_Class {
	final int num = 10;
	
	public void display(){
	int num =12;
		Runnable r = new Runnable(){
			final int num = 15;
			public void run(){
				int num = 20;
				System.out.println(this.num);
			}
		};
		r.run();
	}
	
	public static void main(String args[]){
		Test_Class sv = new Test_Class();
		sv.display();
		String[] testString = new String[5];
		Arrays.sort(testString, (s1,s2)->s1.length()-s2.length());
	}
}
