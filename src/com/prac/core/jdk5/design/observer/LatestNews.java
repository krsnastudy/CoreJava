package com.prac.core.jdk5.design.observer;

public class LatestNews {
	final String messageContent;

	public LatestNews(String m) {
		this.messageContent = m;
	}

	public String getMessageContent() {
		return messageContent;
	}
}
