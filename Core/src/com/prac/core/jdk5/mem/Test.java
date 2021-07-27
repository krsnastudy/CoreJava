package com.prac.core.jdk5.mem;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		Memory.getJVMAvailableMemory();
		
		Test s = new Test();
		s=null;

		for (int i = 0; i < 10; i++) {
			m1();
//			System.gc();
			Memory.requestGCExecute();
		}
		
		Memory.getJVMAvailableMemory();
	}

	public static Map m1() {
		Map<String, String> x = new HashMap<>();
		Map<String, String> y = new HashMap<>();
		return x;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Successfully Garbage Collected\n");
	}
}