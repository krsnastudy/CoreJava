package com.prac.core.jdk5.mem;

public class Memory {
	private static Runtime r;
	private static final int MegaBytes = 1024 * 1024;
	private static final String MB=" MB";

	public static void getJVMAvailableMemory() {
		r = Runtime.getRuntime();

		long freeMemory = r.freeMemory() / MegaBytes;
		long totalMemory = r.totalMemory() / MegaBytes;
		long maxMemory = r.maxMemory() / MegaBytes;

		System.out.println("TotalMemory in JVM Shows Current Heap size: " + totalMemory+MB);
		System.out.println("FreeMemory in JVM: " + freeMemory+MB);
		System.out.println("MaxMemory in JVM: " + maxMemory+MB);
		System.out.println("Used Memory in JVM: " + (maxMemory - freeMemory)+MB);
		System.out.println();
	}
	
	public static void requestGCExecute() {
		r = Runtime.getRuntime();
		r.gc();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("In finalize(), called by requestGCExecute()\n");
	}
}
