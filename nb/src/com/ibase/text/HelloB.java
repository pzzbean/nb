package com.ibase.text;

public class HelloB extends HelloA {
	public HelloB(){
		System.out.println("构造B");
	}
	
	{System.out.println("块Bclass");}
	
	static {System.out.println("static B");}
	
	public static void main(String[] args) {
		System.out.println("-----main start------");
		new HelloB();
		new HelloB();
		System.out.println("-------main end------");
	}

}
