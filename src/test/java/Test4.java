package test.java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test4 {
    public static void main(String[] args) {
        String sPno = "1234567890";

        IntStream.rangeClosed(1, sPno.length())
                .boxed()
                .collect(
                        Collectors.partitioningBy(
                                p -> p % 2 == 0,
                                Collectors.mapping(
                                        i -> Character.getNumericValue(sPno.charAt(i - 1)),
                                        Collectors.toList()
                                )
                        ));
    }
}
