package com.prac.core.jdks.jdk8.optional;

import java.util.Optional;

public class OptionalExample1 {
    public static void main(String[] args) {
        Optional<String> opt = Optional.ofNullable("Java");

        // Checking methods
        System.out.println("isPresent: " + opt.isPresent());
        opt.ifPresent(value -> System.out.println("Value: " + value));

        // Getting values
        System.out.println("orElse: " + opt.orElse("Default"));
        System.out.println("orElseGet: " + opt.orElseGet(() -> "Generated"));

        // Transformations
        opt.map(String::toUpperCase).ifPresent(System.out::println);
        opt.flatMap(val -> Optional.of(val + " 11")).ifPresent(System.out::println);

        // Filtering
        System.out.println("Filtered: " + opt.filter(val -> val.startsWith("J")).isPresent());

        // Combining Optionals
        System.out.println("or(): " + opt.or(() -> Optional.of("Fallback")).get());

        // Stream conversion (Java 9+)
        opt.stream().forEach(System.out::println);
    }
}


/**
 * Summary Table of Optional Methods
 * Category	---> Method
 * Creation ---> of(T), ofNullable(T), empty()
 * Checking ---> isPresent(), ifPresent(Consumer<T>)
 * Getting Values ---> get(), orElse(T), orElseGet(Supplier<T>), orElseThrow(Supplier<E>)
 * Transformation ---> map(Function<T, R>), flatMap(Function<T, Optional<R>>)
 * Filtering ---> filter(Predicate<T>)
 * Combining ---> or(Supplier<Optional<T>>)
 * Stream Conversion ---> stream() (Java 9+)
 * Equality & Debugging ---> equals(), hashCode(), toString()
 * <p>
 * These methods make handling null values safer and more functional.
 **/


