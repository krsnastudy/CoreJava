package com.prac.core.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ColorTest {

	public static void main(String[] args) {
		Map<Color, String> map = new HashMap<>();
		map.put(new Color("Red"), "Red");
		map.put(new Color("Blue"), "Blue");
		map.put(new Color("Green"), "Green");

		// System.out.println(map.get(new Color("Blue")));

		Comparator<Integer> nc = (a, b) -> b.compareTo(a);

		Integer arr[] = { 1, 2, 3, 4 };
		Arrays.sort(arr, nc);
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
	}

}

class Color {
	private String name;

	public Color(String bname) {
		this.name = bname;
	}
}