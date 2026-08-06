package com.prac.core.problem.gen;

import java.util.function.Function;

public class MissingDigitOptimized {

    public static int missingDigit(String str) {

        // Remove spaces
        str = str.replaceAll("\\s+", "");

        // Split equation
        String[] eq = str.split("=");
        String left = eq[0];
        long rightValue = -1;
        boolean rightHasX = eq[1].contains("x");

        char operator = 0;
        int opIndex = -1;

        // Detect operator
        for (char c : new char[]{'+', '-', '*', '/'}) {
            opIndex = left.indexOf(c);
            if (opIndex != -1) {
                operator = c;
                break;
            }
        }

        String a = left.substring(0, opIndex);
        String b = left.substring(opIndex + 1);

        // Try digits 0–9
        for (int d = 0; d <= 9; d++) {
            char digit = (char) ('0' + d);

            long num1 = parse(a, digit);
            long num2 = parse(b, digit);
            long num3 = rightHasX ? parse(eq[1], digit)
                    : Long.parseLong(eq[1]);

            if (isValid(num1, num2, num3, operator)) {
                return d;
            }
        }
        return -1;
    }

    // Parses number replacing x with digit
    private static long parse(String s, char digit) {
        long val = 0;
        for (char c : s.toCharArray()) {
            val = val * 10 + (c == 'x' ? digit - '0' : c - '0');
        }
        return val;
    }

    // Evaluates equation
    private static boolean isValid(long a, long b, long c, char op) {
        switch (op) {
            case '+':
                return a + b == c;
            case '-':
                return a - b == c;
            case '*':
                return a * b == c;
            case '/':
                return b != 0 && a % b == 0 && a / b == c;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Function<String, String> function = f -> "In Expression[" + f + "] value of x is ";
        System.out.println(function.apply("3x + 12 = 46") + missingDigit("3x + 12 = 46")); // 4
        System.out.println(function.apply("4 - 2 = x") + missingDigit("4 - 2 = x")); // 2
        System.out.println(function.apply("8 / x = 4") + missingDigit("8 / x = 4")); // 2
        System.out.println(function.apply("1x * 2 = 36") + missingDigit("1x * 2 = 36")); // 8
    }
}
