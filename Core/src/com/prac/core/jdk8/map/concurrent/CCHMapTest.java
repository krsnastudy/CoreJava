package com.prac.core.jdk8.map.concurrent;

public class CCHMapTest {

	public static void main(String[] args) {
		CCHMapThread cc = new CCHMapThread();
		
		Thread t1 = new Thread(cc, "Thread1");	
		Thread t2 = new Thread(cc, "Thread2");
		
		t1.start();
		t2.start();
		
		StringBuffer sb;
	}

}
