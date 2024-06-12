package com.prac.core.jdk8.predefinedfunctions.supplier;

import java.util.function.Supplier;

public class RandomPassword {

	public static void main(String[] args) {

		final String passString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&";
		Supplier<Integer> digit = () -> (int) (Math.random() * 10);
		Supplier<Integer> randomDigit = () -> (int) (Math.random() * passString.length());

		Supplier<String> s = () -> {
			String pwd = "";

			for (int i = 0; i < 9; i++) {
				if (i % 2 == 0) {
					pwd = pwd + digit.get();
				} else {
					// pwd = pwd + String.valueOf(c.get((int) (Math.random() * 69)));
					pwd = pwd + passString.charAt(randomDigit.get());
				}
			}

			return pwd;
		};

//		System.out.println("Random Password: "+s.get());
		for (int i = 0; i < 10; i++) {
			System.out.println("Random Password(" + i + "): " + s.get());
		}
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