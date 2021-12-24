package com.prac.core.jdk5.arrays;

public class Array {

	private int[] items;
	private int count;
	private final double loadFactor = 2;

	Array(int length) {
		items = new int[length];
	}

	public void print() {
//		Arrays.stream(items).forEach(System.out::println);
//		Arrays.stream(items).forEach(x->System.out.print(x+" "));

		for (int i = 0; i < count; i++) {
			System.out.print(items[i] + " ");
		}
	}

	public void insert(int element) {
		// items[count] = element;
		// count++;

		if (items.length == count) {
			int[] newItems = new int[(int) (count * loadFactor)];

			for (int i = 0; i < count; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}

		items[count++] = element;
	}

	public void removeAt(int idx) {

		int index = idx - 1;

		if (index < 0 || index >= count) {
			throw new IllegalArgumentException();
		}

		for (int i = index; i < count - 1; i++) {
			items[i] = items[i + 1];
		}

		count--;
	}
}
