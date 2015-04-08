package com.reyun.es;

public class B extends A{
	static {
		System.out.println("b1");
	}
	
	public B(){
		System.out.println("b2");
	}
	public int getRe(){
		System.out.println("getB");
		return 1;
	}
	{
		this.getRe();
		System.out.println("b3");
	}

}
