package com.reyun.es;

public class A {

	static{
		System.out.println("a1");
	}
	public A(){
		System.out.println("a2");
	}
	{
		System.out.println("a3");
	}
	
	public int getRe(){
		System.out.println("getA");
		return 1;
	}
}
