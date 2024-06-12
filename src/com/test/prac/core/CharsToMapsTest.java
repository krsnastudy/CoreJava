package com.test.prac.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.prac.core.jdk8.handson.CharsToMaps;

public class CharsToMapsTest {
	static Map<Character, Integer> map;
	static String str = "thisisteststring";
	
	@BeforeAll
	static void setUp() {
		
		map = CharsToMaps.getHashMap(str);
	}

	@Test
	void charToHashMap() {
		assertEquals(str.length(), map.size());
	}
	
	@Test
	void charToLHashMap() {
		assertEquals(str.length(), map.size());
	}
	
	@Test
	void charToTHashMap() {
		assertEquals(str.length(), map.size());
	}
	
	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}
}
