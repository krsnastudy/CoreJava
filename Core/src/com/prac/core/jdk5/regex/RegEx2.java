package com.prac.core.jdk5.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx2 {

	public static void main(String[] argv) throws Exception {

		String jsonString = "(Credit, Loss, PROFIT, Debt)";
		String searchString1 = "Debt";
		String searchString2 = "PrOfIt";

		System.out.println("Json String: " + jsonString);
		System.out.println("[" + searchString1 + "] Is Exists: " + isExists(searchString1, jsonString));
		System.out.println("[" + searchString2 + "] Is Exists: " + isExists(searchString2, jsonString));
	}

	public static boolean isExists(String searchString, String jsonString) {

		String patt = "\\b";
		String framePattern = patt + searchString + patt;

		Pattern p = Pattern.compile(framePattern.toLowerCase());
		Matcher m = p.matcher(jsonString.toLowerCase());
//	   System.out.println("["+searchString+"] matches: " + m.find());

		return m.find();
	}
}
