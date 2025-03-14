package com.prac.core.jdk5.string;

public class StringRotation {

    public static String rotateString(String str, int positions) {
        if (str == null || str.isEmpty() || positions < 0) {
            return str;
        }

        int length = str.length();

        // Use StringBuilder for efficient string manipulation
        StringBuilder rotated = new StringBuilder(length);
        rotated.append(str.substring(length - positions));  // Append last 'positions' characters
        rotated.append(str, 0, length - positions);         // Append the remaining part

        return rotated.toString();


/*        positions = positions % length; // Handle cases where positions > length
        String rotatedPart = str.substring(length - positions);  // Extract last 'positions' characters
        String remainingPart = str.substring(0, length - positions); // Extract remaining part
        return rotatedPart + remainingPart; // Concatenate rotated part at the beginning*/
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        int positions = 3;

        String rotatedString = rotateString(str, positions);
        System.out.println("Original String: " + str);
        System.out.println("Rotated String: " + rotatedString);
    }
}



/*
* Returns a string that is a substring of this string.
* The substring begins with the character at the specified index and extends to the end of this string.
*
* Examples:
* "unhappy".substring(2) returns "happy"
* "Harbison".substring(3) returns "bison"
* "emptiness".substring(9) returns "" (an empty string)
* */