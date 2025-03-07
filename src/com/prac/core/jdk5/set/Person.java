package com.prac.core.jdk5.set;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(builderMethodName = "")
public class Person {

	private String name;
	private int age;

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
