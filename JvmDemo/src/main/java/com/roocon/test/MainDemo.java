package com.roocon.test;
// -XX:+HeapDumpOnOutOfMemoryError  ���ɿ��ա� ������MemoryAnalyzer-1.8.0.20180604-win32.win32.x86_64\mat �鿴

//- XX:+HeapDumpOnOutOfMemoryError 
// -Xms20m -Xmx20m  ����jvm�Ĳ�����
import java.util.ArrayList;
import java.util.List;

public class MainDemo {
	public static void main(String[] args) {
		List<Demo>  listDemo =new ArrayList<Demo>();
		while(true){
			int i=1;
			listDemo.add(new Demo());
			i = i+1;
			System.out.println(i);
		}
	}
}
/**
 *1:jconsole  java �������ͼ�λ���ع��ߡ�
 *2:jps  
 *
 *
 */
