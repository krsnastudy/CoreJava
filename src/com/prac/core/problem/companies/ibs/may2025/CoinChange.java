package com.prac.core.problem.companies.ibs.may2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static List<Integer> coinChange(int[] coins, int amount) {
        List<Integer> result = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {
                result.add(coin);
                amount -= coin;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        // Convert int[] to Integer[] for sorting with comparator
        Integer[] boxedArray = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, (a, b) -> b - a);

        // Optional: Convert back to int[]
        int[] sortedCoins = Arrays.stream(boxedArray).mapToInt(i -> i).toArray();

        List<Integer> change = coinChange(sortedCoins, amount);
        System.out.println("coinChange: "+change); // Output: [5, 5, 1]
    }
}