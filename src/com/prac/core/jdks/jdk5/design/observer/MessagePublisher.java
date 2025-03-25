package com.prac.core.jdks.jdk5.design.observer;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Publisher {

	private List<Subscriber> observers = new ArrayList<>();

	@Override
	public void attach(Subscriber o) {
		observers.add(o);
	}

	@Override
	public void detach(Subscriber o) {
		observers.remove(o);
	}

	@Override
	public void notifyUpdate(LatestNews m) {
		for (Subscriber o : observers) {
			o.update(m);
		}
	}

}
