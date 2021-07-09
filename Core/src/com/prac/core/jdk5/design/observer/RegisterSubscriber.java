package com.prac.core.jdk5.design.observer;

public class RegisterSubscriber {
	private MessagePublisher publisher;
	
	RegisterSubscriber(MessagePublisher publisher){
		this.publisher = publisher;
	}
	
	public MessagePublisher registerSubscriber(Subscriber s) {
		publisher.attach(s);
		return publisher;
	}
}
