package com.prac.core.jdks.jdk5.design.singleton;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	private static Singleton instance=null;
	
	private Singleton(){}

	protected Object readResolve() {
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
    public static Singleton getInstance(){

    	if(instance!=null)
    		return instance;
    	
    	synchronized (Singleton.class) {
			if(instance==null) {
				instance = new Singleton();
			}
		}
    	
    	return instance;
    }
    
}