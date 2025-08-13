package com.prac.core.problem.companies.thermofisher;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CurrencyDenominations {

	public static void main(String[] args) {
		int amount = 1001;
		countCurrency(amount);
	}

	public static void countCurrency(int amount) {
		int[] notes = new int[] { 2000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		int[] noteCounter = new int[notes.length];

		for (int i = 0; i < notes.length; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = amount / notes[i];
				amount = amount % notes[i];
//				System.out.println("Iteration " + i + " --> Count of " + notes[i] + " Note/Coin is " + noteCounter[i]+ ", Remaining Amount is " + amount);
			}
		}
		System.out.println(Arrays.toString(noteCounter));
		/*
		 * // Print notes System.out.println("\nCurrency Count ->"); for (int i = 0; i <
		 * 9; i++) { if (noteCounter[i] != 0) { System.out.println(notes[i] + " : " +
		 * noteCounter[i]); } }
		 */

		System.out.println("Currency Denominations are ");
		IntStream.range(0, notes.length).boxed().filter(f -> noteCounter[f] != 0).forEach(
				e -> System.out.println(notes[e] + " * " + noteCounter[e] + " = " + (notes[e] * noteCounter[e])));
	}

}

/*
 * coins = 1,2,5,10 Sum = 48
 * 
 * 10 * 4 = 40 5 * 1 = 5 2 * 1 = 2 1 * 1 = 1 ===== 7 coins sum is 48
 */
