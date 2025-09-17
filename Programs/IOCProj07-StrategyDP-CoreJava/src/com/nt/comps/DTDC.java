//DTDC.java
package com.nt.comps;

public final class DTDC implements ICourier {
	
	
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DTDC.deliver()");
		return "DTDC  is  delivering the"+ oid+" order id order  products"; 
	}

}
