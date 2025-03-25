package com.prac.core.jdks.jdk5.mem;

import java.util.ArrayList;
import java.util.List;

public class MemoryUtil {

	private static final int MegaBytes = 1024 * 1024;

	public static void main(String args[]) throws InterruptedException {

		long freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
		long totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
		long maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;

		System.out.println("JVM freeMemory: " + freeMemory);
		System.out.println("JVM TotalMemory also equals to Initial Heap size of JVM : " + totalMemory);
		System.out.println("JVM MaxMemory also equals to Maximum Heap size of JVM: " + maxMemory);

		for (int i = 1; i <= 10; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					try {
						List<String> a = new ArrayList<>();
						a = null;
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "Thread-" + i);

			t.start();
			t.join();
		}

		ArrayList<String> objects = new ArrayList<>();

		for (int i = 0; i < 10000000; i++) {
			objects.add(("" + 10 * 2710));
		}

		freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
		totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
		maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;

		System.out.println();
		System.out.println("Used Memory in JVM: " + (maxMemory - freeMemory));
		System.out.println("freeMemory in JVM: " + freeMemory);
		System.out.println("TotalMemory in JVM Shows current size of Java Heap : " + totalMemory);
		System.out.println("MaxMemory in JVM: " + maxMemory);

		Runtime.getRuntime().gc();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize method called");
	}
}

//Read more: https://javarevisited.blogspot.com/2012/01/find-max-free-total-memory-in-java.html#ixzz7129WeegI