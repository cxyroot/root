package com.google.test;

public class StackDemo {
	public void testName()  {
		System.out.println("����ִ�С���");
		testName();
	}
	public static void main(String[] args) {
		new StackDemo().testName();
	}
}
