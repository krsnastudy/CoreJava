package com.prac.core.jdks.jdk5.ds.sorting;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Element> treeSet = new TreeSet<>(StringComparator);
		Element ele1 = new Element(100, "Satya");
		ele1.setId(100);
		ele1.setName("Satya");

		Element ele2 = new Element(200, "RK");
		ele2.setId(200);
		ele2.setName("RK");

		Element ele3 = new Element(500, "Arjun");
		ele3.setId(500);
		ele3.setName("Arjun");

		treeSet.add(ele1);
		treeSet.add(ele2);
		treeSet.add(ele3);

		System.out.println(treeSet);

	}

	static Comparator<Element> IdComparator = (ele1, ele2) -> {
		return ele1.getId().compareTo(ele2.getId());
	};

	static Comparator<Element> StringComparator = (ele1, ele2) -> {
		return ele2.getName().compareTo(ele1.getName());
	};

}

class Element {

	private Integer id;
	private String name;

	public Element(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Element [id=" + id + ", name=" + name + "]";
	}

}
