package com.google.test;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isAlive(){
		System.out.println("yes,i am still");
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize mehtod run ...");
		FinalizeEscapeGC.SAVE_HOOK =this;
	}
	public static void main(String[] args) {
		SAVE_HOOK = new FinalizeEscapeGC();
		
	}
}
