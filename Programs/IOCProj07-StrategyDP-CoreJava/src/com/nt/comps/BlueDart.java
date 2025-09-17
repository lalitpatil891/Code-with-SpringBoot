//BlueDart.java
package com.nt.comps;

public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return "BlueDart  is  delivering the"+ oid+" order  id  order  products"; 
	}

}
