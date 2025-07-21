package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {

	// Has-property
	@Autowired
	@Qualifier("bDart")
	private ICourier courier;

	public Flipkart() {
		System.out.println("Flipkart:: 0-paramConstructor");
	}

	public String shopping(String[] items, double[] prices) {
		System.out.println("Flipkart.shopping()");

		// Calculate bill amount
		double billAmt = 0.0;
		for (double p : prices) {
			billAmt = billAmt + p;
		}

		// generate order id randomly
		int oid = new Random().nextInt(100000);

		// deliver the order using courier
		String msg = courier.deliver(oid);

		return Arrays.toString(items) + "are shopped having amount::" + billAmt + "-->" + msg;
	}
}
