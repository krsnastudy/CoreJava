package com.prac.core.jdks.jdk5.design.observer;

public class SubscriberThree implements Subscriber {

	@Override
	public void update(LatestNews m) {
		System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
	}
}
