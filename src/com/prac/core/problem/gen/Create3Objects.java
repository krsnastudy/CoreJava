package com.prac.core.problem.gen;

public class Create3Objects {

	private Create3Objects() {
	}

	private static Create3Objects obj[];

	static int i = 0;

	public static Create3Objects getInstance() {

		if ((i < 3) && (obj[i] == null)) {
			obj[i] = new Create3Objects();
			return obj[i++];
		} else {
			if (i == 3)
				i--;
			return obj[i];
		}
	}
}