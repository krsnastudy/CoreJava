package com.prac.core.problem.sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Games {
	public static void main(String[] args) {
		
		SportsEmployee se1 = new SportsEmployee("Arjun", 37, new ArrayList<String>(Arrays.asList("Cricket", "Football", "Basketball")));
		SportsEmployee se2 = new SportsEmployee("RK", 41, new ArrayList<String>(Arrays.asList("Cricket", "Basketball")));
		SportsEmployee se3 = new SportsEmployee("Satya", 44, new ArrayList<String>(Arrays.asList("Football", "Basketball")));
		SportsEmployee se4 = new SportsEmployee("Anam", 41, new ArrayList<String>(Arrays.asList( "Basketball", "Football")));
		SportsEmployee se5 = new SportsEmployee("Shabi", 38, new ArrayList<String>(Arrays.asList("Cricket")));
		
		List<SportsEmployee> list = new ArrayList<>();
		list.add(se1);
		list.add(se2);
		list.add(se3);
		list.add(se4);
		list.add(se4);
		
//		list.forEach(System.out::println);
		
		list.stream()
		.filter(s->s.getSportsActivities().contains("Football"))
		.collect(Collectors.toSet())
		.forEach(x->System.out.println(x.name));
		
	}
}
