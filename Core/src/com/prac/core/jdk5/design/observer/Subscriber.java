package com.prac.core.jdk5.design.observer;

@FunctionalInterface
public interface Subscriber {
	public void update(LatestNews m);
}