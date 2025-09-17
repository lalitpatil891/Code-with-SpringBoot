package com.nit.sbeans;

public class B {
	private A a;
	
	public B(A a) {
		this.a= a;
		System.out.println("A:: 1-param constructor");
	}
	
	@Override
	public String toString() {
		return "From B";
	}
}
