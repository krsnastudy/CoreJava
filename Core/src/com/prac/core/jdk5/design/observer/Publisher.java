package com.prac.core.jdk5.design.observer;

public interface Publisher {
	public void attach(Subscriber o);

	public void detach(Subscriber o);

	public void notifyUpdate(LatestNews m);
}
