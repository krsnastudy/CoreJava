package com.prac.core.jdks.jdk8.predefinedfunctions;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class OrderProcessingSystem {

    // ─────────────────────────────────────────────
    // Domain Model
    // ─────────────────────────────────────────────
    static class Order {
        String customerName;
        double amount;
        String city;
        boolean isPrime;

        Order(String customerName, double amount, String city, boolean isPrime) {
            this.customerName = customerName;
            this.amount = amount;
            this.city = city;
            this.isPrime = isPrime;
        }

        @Override
        public String toString() {
            return String.format("Order[customer=%s, amount=%.2f, city=%s, prime=%b]",
                    customerName, amount, city, isPrime);
        }
    }

    public static void main(String[] args) {

        // ═══════════════════════════════════════════════════
        // 1. SUPPLIER<T> — Generates/produces orders (no input, returns output)
        // ═══════════════════════════════════════════════════
        Supplier<Order> orderSupplier1 = () -> new Order("Ravi Kumar", 4500.00, "Bengaluru", true);
        Supplier<Order> orderSupplier2 = () -> new Order("Alice Sharma", 800.00, "Mumbai", false);
        Supplier<Order> orderSupplier3 = () -> new Order("Zara Khan", 12000.00, "Delhi", true);

        List<Supplier<Order>> orderSuppliers = List.of(orderSupplier1, orderSupplier2, orderSupplier3);

        // Generate all orders by invoking each Supplier's get() method
        List<Order> incomingOrders = orderSuppliers.stream()
                .map(Supplier::get)     // .get() — the single abstract method of Supplier
                .collect(Collectors.toList());

        System.out.println("========== STEP 1: Orders Generated (Supplier) ==========");
        incomingOrders.forEach(System.out::println);

        // ═══════════════════════════════════════════════════
        // 2. PREDICATE<T> — Filters/validates orders (input -> boolean)
        // ═══════════════════════════════════════════════════
        Predicate<Order> isHighValue   = order -> order.amount > 1000;
        Predicate<Order> isPrimeMember = order -> order.isPrime;
        Predicate<Order> isFromMetro   = order -> List.of("Bengaluru", "Mumbai", "Delhi").contains(order.city);

        // Predicate.and() — combine multiple conditions (ALL must be true)
        Predicate<Order> eligibleForDiscount = isHighValue.and(isPrimeMember);

        // Predicate.or() — combine conditions (ANY can be true)
        Predicate<Order> eligibleForFreeShipping = isPrimeMember.or(isHighValue);

        // Predicate.negate() — invert the condition
        Predicate<Order> notEligibleForDiscount = eligibleForDiscount.negate();

        System.out.println("\n========== STEP 2: Predicate Checks ==========");
        for (Order order : incomingOrders) {
            System.out.printf("%-20s | High Value: %-5b | Discount Eligible: %-5b | Free Shipping: %-5b%n",
                    order.customerName,
                    isHighValue.test(order),
                    eligibleForDiscount.test(order),
                    eligibleForFreeShipping.test(order));
        }

        // Filter only discount-eligible orders using the combined Predicate
        List<Order> discountEligibleOrders = incomingOrders.stream()
                .filter(eligibleForDiscount)      // .test() used internally by filter()
                .collect(Collectors.toList());

        System.out.println("\nOrders eligible for discount:");
        discountEligibleOrders.forEach(System.out::println);

        // ═══════════════════════════════════════════════════
        // 3. FUNCTION<T,R> — Transforms orders (input -> output, different type)
        // ═══════════════════════════════════════════════════

        // Function 1: Apply 10% discount to amount, return updated Order
        Function<Order, Order> applyDiscount = order -> {
            double discounted = order.amount * 0.90;
            return new Order(order.customerName, discounted, order.city, order.isPrime);
        };

        // Function 2: Add flat "prime shipping fee waiver" note by adjusting amount
        Function<Order, Order> applyPrimeBenefit = order -> {
            if (order.isPrime) {
                return new Order(order.customerName, order.amount - 50, order.city, order.isPrime);
            }
            return order;
        };

        // Function 3: Convert final Order to a formatted receipt String
        Function<Order, String> generateReceipt = order ->
                String.format("RECEIPT -> %s | Final Amount: ₹%.2f | City: %s",
                        order.customerName, order.amount, order.city);

        // Function.andThen() — chain functions: apply discount THEN prime benefit THEN receipt
        Function<Order, Order> fullPricingPipeline = applyDiscount.andThen(applyPrimeBenefit);

        // Function.compose() — reverse order chaining (runs 'before' first)
        // Here demonstrating: generateReceipt happens AFTER fullPricingPipeline via andThen
        Function<Order, String> completeOrderProcessing = fullPricingPipeline.andThen(generateReceipt);

        // Function.identity() — returns input unchanged (useful in Collectors.toMap etc.)
        Function<Order, Order> noOpFunction = Function.identity();

        System.out.println("\n========== STEP 3: Function Transformations ==========");
        List<String> receipts = discountEligibleOrders.stream()
                .map(completeOrderProcessing)   // .apply() used internally by map()
                .collect(Collectors.toList());

        receipts.forEach(System.out::println);

        // ═══════════════════════════════════════════════════
        // 4. CONSUMER<T> — Consumes final data (input -> void, side-effects: print/save/notify)
        // ═══════════════════════════════════════════════════

        Consumer<String> printReceipt = receipt -> System.out.println("[PRINTER] " + receipt);

        Consumer<String> saveToDatabase = receipt -> System.out.println("[DATABASE] Saved: " + receipt);

        Consumer<String> sendSmsNotification = receipt -> System.out.println("[SMS] Notification sent for: " + receipt);

        // Consumer.andThen() — chain multiple consumers to run sequentially on same input
        Consumer<String> fullNotificationPipeline = printReceipt
                .andThen(saveToDatabase)
                .andThen(sendSmsNotification);

        System.out.println("\n========== STEP 4: Consumer Actions (Chained) ==========");
        receipts.forEach(fullNotificationPipeline);   // .accept() used internally by forEach()

        // ═══════════════════════════════════════════════════
        // 5. ALL FOUR WORKING TOGETHER — End-to-End Pipeline
        // ═══════════════════════════════════════════════════
        System.out.println("\n========== STEP 5: Full End-to-End Pipeline ==========");

        Supplier<Order> newOrderSource = () -> new Order("Kiran Rao", 2500.00, "Bengaluru", true);
        Predicate<Order> validationCheck = isHighValue.and(isFromMetro);
        Function<Order, String> processingChain = applyDiscount
                .andThen(applyPrimeBenefit)
                .andThen(generateReceipt);
        Consumer<String> deliveryChain = printReceipt.andThen(saveToDatabase);

        // The full collaborative flow:
        Order newOrder = newOrderSource.get();                  // SUPPLIER produces
        if (validationCheck.test(newOrder)) {                   // PREDICATE validates
            String finalReceipt = processingChain.apply(newOrder); // FUNCTION transforms
            deliveryChain.accept(finalReceipt);                  // CONSUMER consumes
        } else {
            System.out.println("Order rejected: " + newOrder);
        }
    }
}