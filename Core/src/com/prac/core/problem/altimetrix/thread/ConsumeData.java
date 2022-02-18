package com.prac.core.problem.altimetrix.thread;

import java.io.InputStream;

public abstract class ConsumeData implements Runnable {
	  InputStream is;

	  public ConsumeData(InputStream is) {
	    this.is = is;
	    Thread t = new Thread(this);
	    t.start();
	    }

	  public abstract boolean dataConsumption();

	  public void run(){
	    while(dataConsumption());
	    }
	}