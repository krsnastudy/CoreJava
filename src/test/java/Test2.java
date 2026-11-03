package test.java;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        int fSize = new Random().nextInt(5, 30);
        Supplier<Integer> randomInt = () -> new Random().nextInt(1, 999);
        Supplier<List<Integer>> numList =
                () -> Stream.iterate(1, n -> n + 1)
                        .limit(fSize)
                        .map(i -> new Random().nextInt(1, randomInt.get()))
                        .collect(Collectors.toList());

        System.out.println("Series Size " + fSize);
        // Fibonacci
        System.out.println("-------Fibonacci list----");
        String fCollect = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(fSize)
                .map(n -> n[0])
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
//        System.out.println("Fibonacci Series Size "+fSize);
//        System.out.println("Fibonacci Series :: "+collect);
        System.out.format("Fibonacci Series of %d is :: %s\n", fSize, fCollect);

        // Print Odd Even from given list
        System.out.println("\n-------Print Odd Even from given list----");
        List<Integer> oeList = numList.get();
        System.out.println("Odd Even List " + oeList);

        oeList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0))
                .entrySet().stream()
                .forEach(System.out::println);

        //Checks whether a given number is an Armstrong number.
        System.out.println("\n-------Checks whether a given number is an Armstrong number----");
        int checkArmstrong = 99999;  //9474;
//        System.out.println("Is "+checkArmstrong+" Armstrong? " + isArmstrong(checkArmstrong));
        String armstrongs = Stream.iterate(1, n -> n + 1)
                .limit(checkArmstrong)
                .filter(Test2::isArmstrong)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf("Armstrong Numbers under %d are :: %s\n", checkArmstrong, armstrongs);

        // Factorial
        System.out.println("\n-------Factorial list----");
        int number = new Random().nextInt(1, 10);
        long factorial = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);

        // Print Prime Series
        System.out.println("\n-------Prime Series list of size ---- " + fSize);
        long count = Stream.iterate(0, n -> n + 1)
                .limit(50)
                .filter(Test2::isPrimeNumber)
                .peek(x -> System.out.format("%s ", x))
                .count();
    }

    public static boolean isArmstrong(int num) {
        int size = String.valueOf(num).length();

        long sum = String.valueOf(num).chars()
                .map(Character::getNumericValue)
                .map(m -> (int) Math.pow(m, size))
                .sum();

/*        long sum = String.valueOf(num).chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);*/

        return num == sum;
    }

    public static long factorial(int number) {
        return (number < 2) ? 1 : IntStream.rangeClosed(2, number)
//                .peek(System.out::println)
                .reduce(1, (x, y) -> x * y);
    }

    public static boolean isPrimeNumber(int num) {
        if (num < 2 && num >= 0) return false;

//        return !IntStream.rangeClosed(2, num / 2).anyMatch(i -> num % i == 0);
        return IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
    }

}
