package com.roocon.test2;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {
	
	public byte [] b1=new byte[128*1024];
	
	public static void main(String[] args) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finll(1000);
		
	}

	private static void finll(int n) {
		List<JConsoleTest> jc=new ArrayList<>();
		for (int j = 0; j < n; j++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jc.add(new JConsoleTest());
		}
		
	}
}
