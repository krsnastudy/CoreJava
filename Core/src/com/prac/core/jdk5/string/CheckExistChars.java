package com.prac.core.jdk5.string;

public class CheckExistChars {

	public static void main(String[] args) {
		String strChk = "bib";
		checkExistence("bribe", strChk);
		checkExistence("rabbit", strChk);
		checkExistence("dog", strChk);
	}

	public static void checkExistence(String str, String strCheck) {
		int chk = 0;
		char chr = ' ';
		char[] a = str.toCharArray();

		for (int n = 0; n < strCheck.length(); n++) {
			chr = strCheck.charAt(n);
			for (int i = 0; i < str.length(); i++) {
				if (a[i] == chr) {
					chk++;
					break;
				}
			}
		}
		if (chk == strCheck.length()) {
			System.out.println("String : "+str+", to check : "+strCheck);
		}
	}	
}