package com.google.test;
/**
 * 引用计数法
 * @author CAOXIAOYANG
 *
 */
public class MainDemo {
	private Object instance;

	private void Main() {
		byte[] b1 = new byte[20 * 1024 * 1024];
	}

	public static void main(String[] args) {
		MainDemo m1 = new MainDemo();
		MainDemo m2 = new MainDemo();
		m1.instance = m2;
		m2.instance = m1;
		m1 = null;
		m2 = null;
		System.gc();
	}
}
