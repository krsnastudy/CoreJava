package com.prac.core.problem.companies.RSA.queue_threads;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

@Service
public class QueueService {
	private Queue<Object> queue = new ConcurrentLinkedQueue<>();

	public void addToQueue(Object item) {
		queue.add(item);
	}

	public Object getFromQueue() {
		return queue.poll();
	}
}