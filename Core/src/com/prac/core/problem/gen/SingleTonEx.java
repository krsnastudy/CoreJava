package com.prac.core.problem.gen;

import java.io.Serializable;

public class SingleTonEx implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private static SingleTonEx _instance = null;

	private SingleTonEx() {
		if (_instance != null) {
			throw new InstantiationError("Already there");
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	protected Object readResolve() {
		return _instance;
	}

	public static SingleTonEx getInstance() {
		if (_instance != null) {
			return _instance;
		} else {
			synchronized (SingleTonEx.class) {
				if (_instance == null) {
					_instance = new SingleTonEx();
				}
			}
		}
		return _instance;
	}
} // SingleTonEx
