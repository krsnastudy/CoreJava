package com.prac.core.jdks.jdk11.string;

public class StringClassEx {

    public static void main(String[] args) {
        String version = System.getProperty("java.version");
        System.out.println("Jdk Version : " + System.getProperty("java.version"));

        whenRepeatStringTwice_thenGetStringTwice();
    }

    public static void whenRepeatStringTwice_thenGetStringTwice() {
        String output = "La ".repeat(2) + "Land";
        System.out.println(output);
    }

    public void whenStripString_thenReturnStringWithoutWhitespaces() {
        String str = "\n\t  hello   \u2005";
        System.out.println(str.strip().equals("hello"));
    }
}
