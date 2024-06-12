package com.prac.core.problem.sport;

import java.util.List;

public class SportsEmployee {

	String name;
    int age;
    List<String> sportsActivities;// Cricket, Football, Basketball
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getSportsActivities() {
		return sportsActivities;
	}
	public void setSportsActivities(List<String> sportsActivities) {
		this.sportsActivities = sportsActivities;
	}
	
	public SportsEmployee(String name, int age, List<String> sportsActivities) {
		super();
		this.name = name;
		this.age = age;
		this.sportsActivities = sportsActivities;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sportsActivities=" + sportsActivities + "]";
	}
}
