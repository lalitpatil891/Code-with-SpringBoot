package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Component("courier")
//@Primary
@Lazy(true)
public final class DTDC implements ICourier {
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}
	
	@Override
	public String deliver(int oid) {
		return "DTDC courier is ready to deliver"+oid+" order number products";
	}
}
