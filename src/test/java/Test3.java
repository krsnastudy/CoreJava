package test.java;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        int fSize = new Random().nextInt(5, 25);
        Supplier<Integer> randomInt = () -> new Random().nextInt(1, 999);
        Supplier<List<Integer>> numList =
                () -> Stream.iterate(1, n -> n + 1)
                        .limit(fSize)
                        .map(i -> randomInt.get())
                        .collect(Collectors.toList());
        System.out.println("Series Size " + fSize);
        System.out.println("List of size "+fSize +" is :: "+ numList.get()+"\n");

        //Fibonacci
        String fibonacciSeries = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(fSize)
                .map(n -> n[1])
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("------- Fibonacci List ----\n" + fibonacciSeries + "\n");

        String primeList1 = numList.get().stream().filter(Test3::isPrime).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("------- Prime List ----\n" + primeList1 + "\n");

        String str = "This sis an apple it can be eaten and you will get strength";
/*        str.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(f->f.getValue()==1L)
                .forEach(System.out::println);*/

        String res1 = Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
                .collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(f->f.getValue()==1L)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.println(res1);
    }

    public static boolean isPrime(int num) {

        if (num < 2 && num >= 0) return false;
        return IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
    }


    }
