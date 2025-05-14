package test.java;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        String str = "MADAM";
        boolean b = IntStream.range(0, str.length() / 2)
                .noneMatch(m -> str.charAt(m) != str.charAt(str.length()-m - 1));

        System.out.println(b);
    }
}