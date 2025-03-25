package com.prac.core.jdks.jdk5.string;

import java.util.Arrays;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String values = "ddssabafydslkjfldsjf";
//For testing I have added few more characters to the original input
        char c = experiment(values);
        System.out.println("First Non Repeating char : " + c);
    }

    private static char experiment(final String values) {
        char[] repeatableChars = values.toCharArray();
        char nonRepeatingChar = Character.MIN_VALUE;
        for (char c : repeatableChars) {
            int counter = 0;
            int firstOccurance = Arrays.binarySearch(repeatableChars, c);
// this will fetch the last occurrence of the string.
            if (firstOccurance < 0) {
//if the number is minus that means there is not recurrence of the character
                nonRepeatingChar = c; // First non recurrent character is assign
                break;
            }
// Now we will check for the repetitive occurrence, if the character is repeated then the loop will be continued
            if (Arrays.binarySearch(repeatableChars, 0, repeatableChars.length, c) < 1) {
                counter++;
                continue;
            }
            if (counter < 0) {
                nonRepeatingChar = c; // second level checking
            }
        }
        return nonRepeatingChar;
    }
}


