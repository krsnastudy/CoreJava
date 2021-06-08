package com.prac.core.problem.immutable;

public final class Degree {

	private String degreeName;

	public Degree(String degreeName) {
		super();
		this.degreeName = degreeName;
	}

	public String getDegreeName() {
		return degreeName;
	}

	@Override
	public String toString() {
		return  degreeName;
	}
	
	  public Object clone() throws CloneNotSupportedException {
	      return super.clone();
	   }
}
