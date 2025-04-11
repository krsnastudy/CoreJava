package com.prac.core.problem.companies.altimetrix;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestThread {
	public static void main(String a[]) {
		try {
			PipedOutputStream os = new PipedOutputStream();
			PipedInputStream is = new PipedInputStream();
			os.connect(is);
			new SendProduction(os);
			new ReceiveProduction(is);
		} catch (Exception e) {
		}
	}
}

/*

https://www.rgagnon.com/javadetails/java-0140.html

Pipe the output of a thread to the input of another oneTag(s): Thread

We use the PipedOutputStream/PipedInputStream duo. When these streams are 
connected together what is written in the PipedOutputStream can be read in PipedInputStream. 
That connection acts like a queue (FIFO).

Pipeline Thread
  
      +----------+         +----------+
      | thread A |  --- >  | thread B |
      +----------+         +----------+
        (PRODUCE)           (CONSUME)


*/