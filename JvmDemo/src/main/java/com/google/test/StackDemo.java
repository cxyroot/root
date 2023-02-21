package com.google.test;

public class StackDemo {
	public void testName()  {
		System.out.println("·½·¨Ö´ÐÐ¡£¡£");
		testName();
	}
	public static void main(String[] args) {
		new StackDemo().testName();
	}
}
