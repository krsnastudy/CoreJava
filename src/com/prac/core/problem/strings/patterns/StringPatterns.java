package com.prac.core.problem.strings.patterns;

import java.util.function.Consumer;

public class StringPatterns {
    public static Consumer<String> printConsumer = System.out::println; //p->System.out.println(p);
    public static Consumer<String> newLine = p->System.out.println();

    public static void main(String[] args) {
        int num = 5;

        square_hollow_pattern(num);
        number_triangle_pattern(num);
        number_increasing_pyramid_pattern(num);
    }

    public static void square_hollow_pattern(int n){
        int i, j;
        printConsumer.accept("Square Hollow Pattern");
        // outer loop to handle number of rows
        for (i = 0; i < n; i++) {
            //  inner loop to handle number of columns
            for (j = 0; j < n; j++) {
                // star will print only when  it is in first
                // row or last row or first column or last
                // column
                if (i == 0 || j == 0 || i == n - 1
                        || j == n - 1) {
                    System.out.print("*");
                }
                // otherwise print space only.
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        newLine.accept("");
    }

    public static void number_triangle_pattern(int n){
        int i, j;
        printConsumer.accept("Number triangle Pattern");
        // outer loop to handle number of rows
        for (i = 1; i <= n; i++) {
            // inner loop to print space
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // inner loop to print star
            for (j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            // print new line for each row
            System.out.println();
        }
        newLine.accept("");
    }

    public static void number_increasing_pyramid_pattern(int n){
        int i, j;
        printConsumer.accept("Number-increasing Pyramid Pattern");
        // outer loop to handle number of rows
        for (i = 1; i <= n; i++) {
            // inner loop to handle number of columns
            for (j = 1; j <= i; j++) {
                // printing column values upto the row
                // value.
                System.out.print(j + " ");
            }

            // print new line for each row
            System.out.println();
        }
        newLine.accept("");
    }
}


/*
https://www.geeksforgeeks.org/java-pattern-programs/
Java Pattern Programs
Here, you will find the top 25 Java pattern programs with their proper code and explanation.

Table of Content

1. Square Hollow Pattern
2. Number triangle Pattern
3. Number-increasing Pyramid Pattern
4. Number-increasing reverse Pyramid Pattern
5. Number-changing Pyramid Pattern
6. Zero-One Triangle Pattern
7. Palindrome Triangle Pattern
8. Rhombus Pattern
9. Diamond Star Pattern
10. Butterfly Star Pattern
11. Square Fill Pattern
12. Right Half Pyramid Pattern
13. Reverse Right Half Pyramid Pattern
14. Left Half Pyramid Pattern
15. Reverse Left Half Pyramid Pattern
16. Triangle Star Pattern
17. Reverse number Triangle Pattern
18. Mirror Image Triangle Pattern
19. Hollow Triangle Pattern
20. Hollow Reverse Triangle Pattern
21. Hollow Diamond Pyramid
22. Hollow Hourglass Pattern
23. Pascal’s Triangle
24. Right Pascal’s Triangle
25. K Pattern
*/