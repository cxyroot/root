package com.google.test;

public class Test {
	public static void main(String[] args) {
		String s1 = "abc";//字节码常量。
		String s2 = "abc";
		System.out.println(s1 == s2);// 放到了常量池中，用HashSet存放。
		String s3 = new String("abc");//放到了堆内存中。
		System.out.println(s3.intern() == s2);
		s3.intern();
	}
}
