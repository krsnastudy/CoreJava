package com.prac.core.problem.companies.altimetrix;

import java.io.OutputStream;

public abstract class ProduceData implements Runnable {
	OutputStream os;

	public ProduceData(OutputStream os) {
		this.os = os;
		Thread t = new Thread(this);
		t.start();
	}

	public abstract boolean dataProduction();

	public void run() {
		while (dataProduction())
			;
	}
}