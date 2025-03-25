package com.prac.core.jdks.jdk5.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

	public static void main(String args[]) {
		String Str = new String("Welcome to Tutorialspoint.com");

		System.out.print("Return Value :");
		System.out.println(Str.matches("(.*)Tutorials(.*)"));

		System.out.print("Return Value :");
		System.out.println(Str.matches("Tutorials"));

		System.out.print("Return Value :");
		System.out.println(Str.matches("Welcome(.*)"));

		String source = new String("credit, debt");
		String search = new String("debt");
		System.out.print("Search Value (" + search + ") ");
		System.out.println(search.matches("source"));

		Pattern p = Pattern.compile("\\bthis\\b");
		Matcher m = p.matcher("Print this");
		m.find();
		System.out.println(m.group());
	}
}
