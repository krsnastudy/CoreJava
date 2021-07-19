package com.prac.core.jdk5.mem;

import java.util.Date;

public class GarbageCollectorExecute {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("/***** Before Objects Created *****/");
		Memory.getJVMAvailableMemory();
		
		for(int i=0; i<100000; i++) {
			Date d = new Date();
			d=null;
//			Thread.currentThread().sleep(1);
		}
		
		System.out.println("/***** After Objects Created *****/");
		Memory.getJVMAvailableMemory();
		
		Memory.requestGCExecute();
		
		System.out.println("/***** After Running GC *****/");
		Memory.getJVMAvailableMemory();
	}
}

/*

https://www.geeksforgeeks.org/difference-between-wait-and-sleep-in-java/

*/
