package com.prac.core.jdk5.mem;

public class IslandofIsolation {

	IslandofIsolation i;

	public static void main(String[] args) {
		IslandofIsolation t1 = new IslandofIsolation();
		IslandofIsolation t2 = new IslandofIsolation();
		t1.i = t2;
		t2.i = t1;
		t1 = null;
		t2 = null;
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize method called");
	}

}

/*
 * 
 * https://data-flair.training/blogs/island-of-isolation-in-java/ The Island of
 * Isolation in Java In Java, object destruction is taken care by the Garbage
 * Collector module and the objects which don’t have any references to them are
 * qualified for garbage gathering. Java garbage collector is a specialist,
 * proficient to distinguish this sort of objects.
 * 
 * The Island of Isolation in Java: When object 1 references Object 2 and Object
 * 2 references Object 1, but neither Object 1 nor Object 2 is referenced by
 * some other object than that is an island of confinement. Essentially, an
 * island of isolation in Java is a gathering of items that reference each other
 * however they are not referenced by any dynamic object in the application.
 * Entirely, even a solitary unreferenced object is an island of isolation as
 * well.
 * 
 */