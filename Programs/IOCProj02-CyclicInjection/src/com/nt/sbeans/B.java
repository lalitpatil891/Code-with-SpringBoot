//B.java
package com.nt.sbeans;

public class B {
	private   A  a;
	
	public B(A  a) {
		this.a=a;
		System.out.println("B:: 1-param constructor");
	}
	
	/*public void setA(A  a) {
		System.out.println("B.setA()");
		this.a=a;
	}*/
	
	public  String toString() {
		return "B.....";
	}

}
