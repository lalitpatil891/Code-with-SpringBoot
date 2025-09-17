package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public final class BlueDart implements Courier {
	
	@Override
	public String deliver(int oid) {
		return oid+" order items are kept of delivery by BlueDart";
	}
	
}
