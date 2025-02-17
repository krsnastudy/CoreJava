package com.prac.core.problem.strings;

import java.util.stream.IntStream;

public class NumberToWords {

    public static void main(String[] args) {
        int number = 130958;

        String result = convertNumberToWords(number);
        System.out.println(number + " To Words: " + result);
    }

    private static String convertNumberToWords(int number) {
        String numStr = Integer.toString(number);
        StringBuilder result = new StringBuilder();
        printASCIIValues();

        for (char digit : numStr.toCharArray()) {
            int digitValue = digit - '0'; // *logic
//            System.out.println("Array Index: "+digitValue);
            result.append(digitWords[digitValue] + " ");
        }

        return result.toString();
    }

    private static final String[] digitWords = {"zero", "one", "two", "three", "four", "five", "six"
            , "seven", "eight", "nine"
    };

    private static void printASCIIValues() {
//        IntStream.rangeClosed(0,255).forEach(i->System.out.println(" The ASCII value of " + (char)i + "  =  " + i) );
//        IntStream.rangeClosed(0,255).forEach(i->System.out.print("(" + (char)i + ")-->" + i+", ") );
//        IntStream.rangeClosed(3077,3204).forEach(i->System.out.print("(" + (char)i + ")-->" + i+", ") );

        System.out.print("ASCII Values: ");
        IntStream.rangeClosed(48, 57).forEach(i -> System.out.print("(" + (char) i + ")-->" + i + ", "));
        System.out.println();
    }
}
