package com.test.prac.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.prac.core.jdks.jdk5.gen.Adding;

class AddingTest {

	@Test
	void testPublic() {
		Adding a = new Adding();
		
		int s = a.add(5, 4);
		
		assertEquals(9, s);
	}
	
	@Test
	public void testPrivate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method methods = Adding.class.getDeclaredMethod("addPrivate", Integer.class, Integer.class); 
		methods.setAccessible(true);
		Adding a = new Adding();
		int sum = (int) methods.invoke(a, 10, 4);
		assertEquals(14, sum);
	}

}
