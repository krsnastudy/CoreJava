package com.prac.core.jdk5.string;

public class AreRotations_String {
    public static void main(String[] args) {
        String s1 = "krsna";
        String s2 = "akrsn";

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (StringRotation.rotateString(s1, i).equals(s2)) {
                    System.out.println(s1 + " & " + s2 + " are Matched after rotating :: " + i + " Index");
                    break;
                }
            }
        }
    }
}
