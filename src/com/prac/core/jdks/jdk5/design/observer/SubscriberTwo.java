package com.prac.core.jdks.jdk5.design.observer;

public class SubscriberTwo implements Subscriber {
	@Override
	public void update(LatestNews m) {
		System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
	}
}
