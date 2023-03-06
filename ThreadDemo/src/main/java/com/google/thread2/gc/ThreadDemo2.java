package com.google.thread2.gc;

public class ThreadDemo2 {
	public static void main(String[] args) {
		new Demo();
		new Demo();
		new Demo();
		new Demo();
		new Demo();
		new Demo();
		System.gc();
		new Demo();
		new Demo();
	}
}
