package com.prac.core.jdk8.predefinedfunctions.supplier;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class RandomPassword {

	public static void main(String[] args) {

		int pwdLength = 14, noOfPwdCount=9;
		final String passString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&_+=)(&%~|-";
		Supplier<Integer> digit = () -> (int) (Math.random() * 10);
		/*Supplier<Integer> randomDigit = () -> (int) (Math.random() * passString.length()); //randomDigit.get()*/
		IntSupplier randomDigit = () -> (int) (Math.random() * passString.length());  //randomDigit.getAsInt()
		System.out.println("Generating Password of Length: "+pwdLength+" & Count: "+noOfPwdCount+" -- randomDigit: "+randomDigit.getAsInt());

		Supplier<String> randomPassword = () -> {
			String pwd = "";

/*			for (int i = 0; i < pwdLength; i++) {
				if (i % 2 == 0) {
					pwd = pwd + digit.get();
				} else {
					// pwd = pwd + String.valueOf(c.get((int) (Math.random() * 69)));
					pwd = pwd + passString.charAt(randomDigit.getAsInt());
				}
			}*/

			for (int i = 0; i < pwdLength; i++) {
				if(getRandomBoolean() && (i % new Random().nextInt(1,9) == 0)) {
					pwd = pwd + digit.get();
				} else {
					// pwd = pwd + String.valueOf(c.get((int) (Math.random() * 69)));
					int idx = randomDigit.getAsInt();
//					System.out.println(" randomDigit.getAsInt() :: "+idx);
					pwd = pwd + passString.charAt(idx);
				}
			}

			return pwd;
		};

//		System.out.println("Random Password: "+randomPassword.get());
		for (int i = 0; i < noOfPwdCount; i++) {
			System.out.println("Random Password(" + i + "): " + randomPassword.get());
		}
	}

	public static boolean getRandomBoolean() {
		return Math.random() < 0.5;
	}
}

/*
 * -- Using ASCII Supplier<List<Character>> chList = () -> { List<Character> ch
 * = new ArrayList<>(); for (int i = 33; i <= 122; i++) { if (i >= 33 && i <=
 * 47) { ch.add((char) i); } else if (i >= 64 && i <= 90) { ch.add((char) i); }
 * else if (i >= 97 && i <= 122) { ch.add((char) i); } }
 * 
 * return ch; };
 * 
 * List<Character> c = chList.get();
 */