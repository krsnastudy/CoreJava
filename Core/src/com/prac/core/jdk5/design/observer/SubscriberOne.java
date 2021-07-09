package com.prac.core.jdk5.design.observer;

public class SubscriberOne implements Subscriber {

	@Override
	public void update(LatestNews m) {
		System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
	}
}