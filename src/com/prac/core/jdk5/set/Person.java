package com.prac.core.jdk5.set;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder(builderMethodName = "Person")
public class Person {

	private String name;
	private int age;

	public Person(String xyz, int i) {
		this.name=xyz;
		this.age = i;
	}

	@Override
	public int hashCode() {
//		return Objects.hash(age, name);
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
//		return age == other.age && Objects.equals(name, other.name);
		return Objects.equals(name, other.name);
	}

}
