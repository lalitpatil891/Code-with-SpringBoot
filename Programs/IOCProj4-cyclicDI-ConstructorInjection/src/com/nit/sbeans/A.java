//A.java
package com.nit.sbeans;

public class A {
		private B b;
		
		public A(B b) {
			this.b = b;
			System.out.println("B:: 1-param Constructor");
		}
		
		public String toString() {
			return "From A";
		}
}
