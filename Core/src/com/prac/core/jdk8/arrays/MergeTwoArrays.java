package com.prac.core.jdk8.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoArrays {

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 2, 3 };
		Integer[] b = new Integer[] { 4, 5, 6 };

		System.out.println("Given Array a: " + Arrays.toString(a));
		System.out.println("Given Array b: " + Arrays.toString(b));

		Object[] streamConcat = StreamConcat(a, b);
		Object[] systemArraycopy = StreamConcat(a, b);
		Object[] javaCollections = StreamConcat(a, b);
		Object[] collectionsAddAll = StreamConcat(a, b);

		System.out.println("Using Stream.concat(): " + Arrays.toString(streamConcat));
		System.out.println("Using System.arraycopy(): " + Arrays.toString(systemArraycopy));
		System.out.println("Using Java Collections for Java 8 Stream: " + Arrays.toString(javaCollections));
		System.out.println("Using Collections.addAll(): " + Arrays.toString(collectionsAddAll));

	}

	public static <T> Object[] StreamConcat(T[] a, T[] b) {

		// Function to merge two arrays of same type
		return Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
	}

	public static <T> Object[] systemArraycopy(T[] a, T[] b) {
		// Create an empty Object array of the combined
		// size of the array a and array b
		Object[] n = new Object[a.length + b.length];

		// Copy the array a into n
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int
		// length)
		System.arraycopy(a, 0, n, 0, a.length);

		// Copy the array b into n
		System.arraycopy(b, 0, n, a.length, b.length);

		return n;
	}

	public static <T> Object[] javaCollections(T[] a, T[] b) {

		// Create an empty List of type Object
		List<Object> n = new ArrayList<>();

		// Add arrays to list
		Stream.of(a, b).flatMap(Stream::of).forEach(n::add);

		// Convert list to array and return
		return n.toArray();
	}

	public static <T> List<Object> collectionsAddAll(T[] a, T[] b) {
		// Create an empty List of type Object
		List<Object> n = new ArrayList<>();

		// Add the array a into n
		// Collections.addAll(Collection<? super T> c, T... elements)
		Collections.addAll(n, a);

		// Add the array b into n
		Collections.addAll(n, b);

		return n;
	}
}

/*
 * https://www.geeksforgeeks.org/merge-arrays-into-a-new-object-array-in-java/
 */