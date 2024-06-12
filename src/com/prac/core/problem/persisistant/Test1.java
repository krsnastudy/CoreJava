package com.prac.core.problem.persisistant;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Hello World");
		int val = 9;
		
		StringBuffer sb = new StringBuffer();
		for (int i = val; i > 0; i--) {
			String temp = "";
			int limit = val - i;
			for (int j = 0; j < (limit + 1); j++) {
				temp = temp + i;
			}
			sb.append(temp);
		}
		System.out.println(sb.toString());
	}
}

/*
  Accept a number from the user say 5 
  Then the output will be 544333222211111

*/
