package com.test.prac.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AppTest {

	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach executed");
	}

	@Tag("DEV")
	@Test
	void testCalcOne() {
		System.out.println("======testCalcOne EXECUTED=======");
		// Assertions.assertEquals( 4 , Calculator.add(2, 2));
		Assertions.assertEquals( 4 , (4+4));
	}

	@Tag("PROD")
	@Disabled
	@Test
	void testCalcTwo() {
		System.out.println("======testCalcTwo EXECUTED=======");
//		Assertions.assertEquals( 6 , Calculator.add(2, 4));
	}

	@AfterEach
	void tearThis() {
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}
}