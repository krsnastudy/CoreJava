package com.prac.core.jdks.jdk5.design.observer;

@FunctionalInterface
public interface Subscriber {
	public void update(LatestNews m);
}