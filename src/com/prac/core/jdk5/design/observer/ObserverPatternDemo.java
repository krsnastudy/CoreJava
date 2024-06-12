package com.prac.core.jdk5.design.observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		SubscriberOne m1 = new SubscriberOne();
		SubscriberTwo m2 = new SubscriberTwo();
		SubscriberThree m3 = new SubscriberThree();

		MessagePublisher p = new MessagePublisher();

		p.attach(m1);
		p.attach(m2);
		p.notifyUpdate(new LatestNews("First Message"));

		System.out.println();
		p.detach(m2);
		p.attach(m3);
		p.notifyUpdate(new LatestNews("Second Message"));
	}
}

/*
 * Observer pattern is used when there is one-to-many relationship between
 * objects such as if one object is modified, its depenedent objects are to be
 * notified automatically. Observer pattern falls under behavioral pattern
 * category.
 * 
 * In observer pattern, there are many observers (subscriber objects) that are
 * observing a particular subject (publisher object). Observers register
 * themselves to a subject to get a notification when there is a change made
 * inside that subject.
 * 
 * A observer object can register or unregister from subject at any point of
 * time. It helps is making the objects objects loosely coupled
 */