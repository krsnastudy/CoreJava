package com.prac.core.problem.companies.persisistant.feb2022;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {
	public static void main(String[] args) {

		List<byte[]> list = new ArrayList<>();
		int index = 1;
		while (true) {
			// 1MB each loop, 1 x 1024 x 1024 = 1048576
			byte[] b = new byte[1048576];
			list.add(b);
			Runtime rt = Runtime.getRuntime();
			System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
		}
	}
}

/*

https://mkyong.com/java/how-to-simulate-java-lang-outofmemoryerror-in-java/

*/