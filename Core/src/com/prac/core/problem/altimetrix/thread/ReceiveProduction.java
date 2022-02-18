package com.prac.core.problem.altimetrix.thread;

import java.io.InputStream;

public class ReceiveProduction extends ConsumeData {
	InputStream input;

	ReceiveProduction(InputStream is) {
		super(is);
		this.input = is;
	}

	public boolean dataConsumption() {
		int i = 0;
		try {
			for (;;) {
				i = input.read();
				System.out.println("  " + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}