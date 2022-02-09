package com.prac.core.jdk5.design.singleton;

import java.io.Serializable;

public class SingtonEx implements Serializable, Cloneable {
	private static final long serialVersionUID = -7921604620670225986L;
	private static SingtonEx _instance = null;

	private SingtonEx() {
		if (_instance != null) {
			throw new InstantiationError("Already there");
		}
	}

	protected Object readResolve() {
		return _instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
//      throw new CloneNotSupportedException();
		return super.clone();
	}

	public static SingtonEx getInstance() {
		if (_instance != null)
			return _instance;

		synchronized (SingtonEx.class) {
			if (_instance == null) {
				_instance = new SingtonEx();
			}
		}
		return _instance;
	}
}
