package com.prac.core.problem.companies.altimetrix;

import java.io.OutputStream;

public class SendProduction extends ProduceData {
	OutputStream output;

	SendProduction(OutputStream os) {
		super(os);
		this.output = os;
	}

	public boolean dataProduction() {
		byte[] j = new byte[1];
		boolean done = false;
		java.util.Random r = new java.util.Random();
		while (!done) {
			try {
				j[0] = (byte) (Math.abs(r.nextInt()) % 255);
				System.out.print(".");
				output.write(j);
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}
		}
		return done;
	}
}