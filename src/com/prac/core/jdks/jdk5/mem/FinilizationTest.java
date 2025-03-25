package com.prac.core.jdks.jdk5.mem;

public class FinilizationTest {
	static FinilizationTest s;
	private int classVariable;

	public FinilizationTest(int classVariable) {
		super();
		this.classVariable = classVariable;
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("FinilizationTest Started");
		FinilizationTest t = new FinilizationTest(5);

//		t.finalize(); /* java.lang.ArithmeticException: / by zero Error */
		System.out.println("First: " + t.hashCode());

		t = null;
		System.gc();

//		System.out.println("Second: "+s.hashCode());

		s = null;
		System.gc();
		System.out.println("FinilizationTest Ended");
	}

	@Override
	protected void finalize() {
		System.out.println("classVariable: " + classVariable);

		// System.out.println(10 / 0);
		s = this;

		System.out.println("In Finalize() ");

		/*
		 * try { System.out.println(10 / 0); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}
}