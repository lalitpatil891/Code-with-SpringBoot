package com.nt.sbeans;

public class B {
	private A a;
	public B() {
		System.out.println("B::O-param constructor");
	}
	
	public void setA(A a) {
		System.out.println("B.setA()");
		this.a=a;
	}
	
	@Override
	public String toString() {
		return "Form B";
	}
}
