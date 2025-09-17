//Flipkart.java (target class)
package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public class Flipkart {
	//HAS-A property
	@Autowired
	@Qualifier("bDart")
	private Courier courier;
	
	//b.method
	public String shopping(String items[], float[] fs) {
		//calculate bill amount
		double billAmount= 0.0;
		for(double p: fs) {
			billAmount = billAmount+p;
		}
		
		//generate the order id (Random number as the order)
		int oid = new Random().nextInt(1000);
		
		//deliver the products using courier
		String msg = courier.deliver(oid);
		
		return Arrays.toString(items)+"items with billAmount::"+billAmount+"---"+msg;
	}
	
}
