package com.prac.core.jdks.jdk8.predefinedfunctions.consumer;

import java.util.function.Consumer;

public class AndThenDemo {

    public static void main(String[] args) {

        Consumer<String> step1 = action -> System.out.println("Step 1: Validate → " + action);
        Consumer<String> step2 = action -> System.out.println("Step 2: Process → " + action);
        Consumer<String> step3 = action -> System.out.println("Step 3: Notify  → " + action);

        // Chain step1 → step2 → step3 using andThen()
        Consumer<String> pipeline = step1.andThen(step2).andThen(step3);

        // Now wrap the entire pipeline inside a Consumer<Consumer<String>>
        Consumer<Consumer<String>> orchestrator = action -> {
            System.out.println("=== Pipeline Start ===");
            action.accept("PaymentRequest-4521");
            System.out.println("=== Pipeline End ===");
        };

        orchestrator.accept(pipeline);
    }
}