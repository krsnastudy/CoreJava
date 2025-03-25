package com.prac.core.jdks.jdk8.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimePractice {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String sdt = ldt.toString();

		System.out.println(sdt);

		System.out.println(new Date());

		System.out.println(Instant.now().toString());
	}

}
