package test.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        String str = "MADAM";
        boolean b = IntStream.range(0, str.length() / 2)
                .noneMatch(m -> str.charAt(m) != str.charAt(str.length()-m - 1));

        System.out.println(b);

        String string = "Venkata radhaKrishna Cheetirala";
        string = string.replaceAll(" ", "").toLowerCase();
        List<Character> collect = string.chars().distinct().mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}