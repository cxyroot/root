package com.google.thread2.gc;

public class Demo {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("123");
	}
	
}
