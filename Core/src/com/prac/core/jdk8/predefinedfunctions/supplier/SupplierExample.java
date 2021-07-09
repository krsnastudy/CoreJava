package com.prac.core.jdk8.predefinedfunctions.supplier;

import java.util.Date;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<Date> s = () -> new Date();
		System.out.println("Supplier Date: " + s.get());

		Supplier<Integer> r1 = () -> new Random().nextInt(5);
		System.out.println("Supplier RandomInt: " + r1.get());

		Supplier<Double> r2 = () -> Math.random();
		int x = (int) (r2.get() * 10);
		System.out.println("Supplier RandomDouble: " + r2.get() + " -- " + x);

		Supplier<String> s1 = () -> {
			String otp = "";

			for (int i = 0; i < 6; i++) {
				otp = otp + ((int) (Math.random() * 10));
			}

			return otp;
		};

		for (int i = 0; i < 2; i++) {
			System.out.println("OTP(" + i + "): " + s1.get());
		}

		
/*** Primitive specializations of the Java 8 Supplier interface ***/
		System.out.println("\n/*** Primitive specializations of the Java 8 Supplier interface ***/");
		String product = "Android";
		double price = 659.50;
		  
		BooleanSupplier boolSupplier = () -> product.length() == 10;
        IntSupplier intSupplier = () -> product.length() - 2;
        DoubleSupplier doubleSupplier = () -> price -20;
        LongSupplier longSupplier = () -> new Date().getTime();
        Supplier<String> supplier = () -> product.toUpperCase();
        
        System.out.println("getAsBoolean(): "+boolSupplier.getAsBoolean());//false
        System.out.println("getAsInt(): "+intSupplier.getAsInt());//5
        System.out.println("getAsDouble(): "+doubleSupplier.getAsDouble());//639.5
        System.out.println("getAsLong(): "+longSupplier.getAsLong());// 1581187440978 (it depends on current time)
        System.out.println("get(): "+supplier.get());//ANDROID		
	}
}

/*
 * Math.random() -- Always return 0<=x<1
 */


/*
Java 8 Supplier is a functional interface whose functional method is  get().
The Supplier interface represents an operation that takes no argument and returns a result. 
As this is a functional interface and can therefore be used as the assignment target 
for a lambda expression or method reference.

*/