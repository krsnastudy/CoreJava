package com.prac.core.jdk8.methodreference;

public class Test {

	Test(){
		System.out.println("Constructor() in Test Class");
	}
	
	public static void main(String[] args) throws InterruptedException {

		Calculate staticObj = Test::staticReference;
		System.out.println("\nCalling Static Reference Method");
		staticObj.callReference();

		Test m = new Test();
		Calculate instanceObj = m::instanceReference;

		System.out.println("\nCalling Instance Reference Method");
		instanceObj.callReference();
		
		Runnable r = () -> {
			for(int i=0; i<128; i++) {
				System.out.print((char)i+"("+i+") ");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		System.out.println("\nCalling Instance Runnable ReferenceExample");
		Thread t = new Thread(r, "ReferenceExample");
		t.start();
		t.join();
		
		System.out.println("\n\nCalling Instance Runnable methodOne");
		Runnable ro = m::methodOne;
		Thread t1= new Thread(ro, "Runnable");
		t1.start();
		
//		t.stop();
//		t1.stop();
		
		Calculate constructor = Test::new;
		System.out.println("\nTest Class Constructor Reference: ");
		constructor.callReference();
		System.out.println();
	}

	public static void staticReference() {
		System.out.println("In MethodReference class staticReference()");
	}

	public void instanceReference() {
		System.out.println("In MethodReference class instanceReference()");
	}
	
	public void methodOne() {
		for(int i=0; i<10; i++){
			System.out.print(i+" ");
		}
	}
}

/*
 -- Syntax for method reference 

 Static: classname::methodname; 
 	Eg: Test::reference;
  
 Instance: ObjectReference::methodname 
 	Eg: m::instanceReference;
 
 */