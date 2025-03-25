package com.prac.core.jdks.jdk8.stream.employee.records;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Gender {
	private static final Random RANDOM = new Random();
	private static final List<GenderCode> VALUES = Collections.unmodifiableList(Arrays.asList(GenderCode.values()));
	private static final int SIZE = VALUES.size();

	public static GenderCode getRandomGender() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
