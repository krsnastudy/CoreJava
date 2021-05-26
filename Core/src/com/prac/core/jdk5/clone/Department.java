package com.prac.core.jdk5.clone;

public class Department implements Cloneable{
	private int id;
    private String name;
 
    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    // Deep Copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
