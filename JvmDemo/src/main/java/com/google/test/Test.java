package com.google.test;

public class Test {
	public static void main(String[] args) {
		String s1 = "abc";//�ֽ��볣����
		String s2 = "abc";
		System.out.println(s1 == s2);// �ŵ��˳������У���HashSet��š�
		String s3 = new String("abc");//�ŵ��˶��ڴ��С�
		System.out.println(s3.intern() == s2);
		s3.intern();
	}
}
