package com.prac.core.problem.companies.RSA.queue_threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	private QueueService queueService;

	@Async
	public void producerMethod() {
		// Producer logic
		Object data = "XYZ"; // generate or fetch data
		queueService.addToQueue(data);
	}

	@Async
	public void consumerMethod() {
		// Consumer logic
		Object data = queueService.getFromQueue();
		// process the data
	}
}