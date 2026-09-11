package com.prac.core.problem.character;

public class CharacterSequence {

	public static void main(String[] args) {

		String str = "ABC";
		String res = "";
		int addLen = 5;
		for (int i = 0; i < str.length(); i++) {
//            System.out.println(Character.getNumericValue(str.charAt(i)));
            res = res + (char)(Character.getNumericValue(str.charAt(i))+addLen);
		}

		System.out.println(" Given String: " + str);
		System.out.println("Change String: " + res);
	}

}
