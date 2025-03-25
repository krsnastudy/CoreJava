package com.prac.core.jdks.jdk5.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleton {

	public static void main(String[] args) {

		/* Reflection */
		try {
//            Constructor constructor = SingtonEx.class.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            objTwo = (SingtonEx) constructor.newInstance();

			// load class
			Class c = Class.forName("com.prac.core.jdks.jdk5.design.singleton.Singleton");
			// get all constructors (whether public or private)
			Constructor[] constructors = c.getDeclaredConstructors();
			// suppress access check errors
			constructors[0].setAccessible(true);
			// instance no 1
			System.out.println(constructors[0].newInstance());
			// instance no 2
			System.out.println(constructors[0].newInstance());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
				e.printStackTrace();
		} catch (IllegalAccessException e) {
				e.printStackTrace();
		} catch (IllegalArgumentException e) {
				e.printStackTrace();
		} catch (InvocationTargetException e) {
				e.printStackTrace();
		}
		/* Reflection */

	}
}

// https://codippa.com/how-to-break-singleton-in-java/