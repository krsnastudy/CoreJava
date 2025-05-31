package com.prac.core.jdks.jdk8.regExp;

public class ZeroOrMoreOccurances {
    public static void main(String[] args) {
        String matchString = "pq";
        System.out.println(validate(matchString,"p"));
        System.out.println(validate(matchString,"pq"));
        System.out.println(validate(matchString,"pqq"));
        System.out.println(validate(matchString,"pqr"));
        System.out.println(validate(matchString,"prr"));

        System.out.println("/**********************************/");
        System.out.println(validate("p"));
        System.out.println(validate("pq"));
        System.out.println(validate("pqq"));
        System.out.println(validate("pqr"));
        System.out.println(validate("prr"));

    }

    public static String validate(String matchString, String text) {
        String checkPattern = matchString+"*?";
        if (text.matches(checkPattern))
            return "Found a match!";
        else
            return "Not matched!";
    }

    public static String validate(String text) {
        if (text.matches("pq*?"))
            return "Found a match!";
        else
            return "Not matched!";
    }
}
