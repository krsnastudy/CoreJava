package test.java;

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

        String fibonacci = Stream.iterate(new Long[]{0L,1L}, n->new Long[]{n[1], n[1]+n[0]})
                .limit(25).map(n->n[0])
                .map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Fibonacci Series :: "+fibonacci);
    }
}