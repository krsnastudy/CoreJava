package com.prac.core.threads.thread;

public class Printer{
	
	void printDocuments(int noOfCopies, String docName, String threadName) {
		synchronized(this) {
			for(int i=1;i<=noOfCopies;i++) {
				System.out.println(threadName+"-Thread - Printing #"+i+" -- Document Name: "+docName);
			}
			System.out.println();
		}
	}
}
