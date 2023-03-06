package com.google.thread2;

public class Demo {
	private String name;
	Demo(String name){
		this.name=name;
	}
	public void show(){
		for (int i = 0; i < 100; i++) {
			System.out.println(name+"..."+ i);
		}
		
	}
}
