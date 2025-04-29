package com.prac.core.problem.companies.ibm.goldmansacs.dec2022;

public class MakePalindrome {

    public static void main(String[] args) {
        String input = "abca";
        String palindrome = makePalindrome(input);
        System.out.println("Result: " + palindrome);
    }

    static String makePalindrome(String str) {
        if (str == null || str.isEmpty()) return str;

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                // Add character at end and restart
                str = str.substring(0, str.length()) + str.charAt(i) + reverse(str.substring(0, i + 1));
                break;
            }
        }

        return str;
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
