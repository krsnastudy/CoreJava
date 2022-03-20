package com.prac.core.problem.threads;

public class OddEvenThread implements Runnable {

	private int printLimit;

	OddEvenThread(int i) {
		super();
		this.printLimit = i;
	}

	@Override
	public void run() {
		synchronized(this) {
		 for(int i=1; i<=printLimit; i++) {
		  try {
				if(i%2==0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
					notify();
//					System.out.println("EvenNumber:"+i);
					System.out.println(i);
					wait();
				}else if(i%2!=0 && Thread.currentThread().getName().equalsIgnoreCase("odd")) {
					notify();
//					System.out.println("OddNumber:"+i);
					System.out.println(i);
					wait();
				}
			  
			} catch (Exception e) {
				e.printStackTrace();
			} // catch
		 }// for
	} // synchronized
  } // run()
} // OddEvenThread


/*


		IntStream.iterate(0, n -> n + 1).limit(printLimit)
		.forEach(i -> {
			try {

				if (i % 2 == 0 && Thread.currentThread().getName().equals("even")) {
					notify();
					System.out.println(i);
					wait();
				} else if (i % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
					notify();
					System.out.println(i);
					wait();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

*/