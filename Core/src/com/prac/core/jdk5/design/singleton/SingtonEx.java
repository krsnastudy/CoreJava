package com.prac.core.jdk5.design.singleton;

import java.io.Serializable;

public class SingtonEx implements Serializable{
	private static final long serialVersionUID = -7921604620670225986L;
	private static SingtonEx _instance=null;
	private static Object obj = new Object();
	
	private SingtonEx() {}
	
	public static SingtonEx getInstance() {
		if(_instance!=null)
			return _instance;
		
		synchronized(obj) {
			if(_instance==null) {
				_instance = new SingtonEx();
			}
		}
		return _instance;
	}
}
