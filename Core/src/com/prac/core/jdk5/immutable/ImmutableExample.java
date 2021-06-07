package com.prac.core.jdk5.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableExample {

	private final List<String> strings = new ArrayList<String>();

	public ImmutableExample() {
		strings.add("string 1");
		strings.add("string 2");
	}

	public List<String> getStrings() {
		List<String> newStrings = new ArrayList<String>();
//		strings.forEach(s -> newStrings.add(s));
		strings.forEach(newStrings::add);
		return newStrings;
	}

	public static void main(String[] args) {
		ImmutableExample im = new ImmutableExample();
		System.out.println(im.getStrings());
		
		im.getStrings().add("string 3");
		System.out.println(im.getStrings());

	}
}