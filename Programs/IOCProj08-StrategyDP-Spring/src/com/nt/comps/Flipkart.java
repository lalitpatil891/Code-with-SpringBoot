//Flipkart.java (Target class)
package com.nt.comps;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	@Autowired  //Field Injection
	@Qualifier("dtdc")
	private ICourier  courier;  //HAS-A property
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}
	
	
	
	//b.method
	public  String   shopping(String [] items, double [] prices) {
		System.out.println("Flipkart.shopping()");
		// calculate bill amount
		double  billamt=0.0;
		for(double p:prices)
			billamt=billamt+p;
		//generate the order id
		 Random rand=new Random();
		 int oid=rand.nextInt(10000);
		 // use  courier
		  String  msg=courier.deliver(oid);
		  //  generate the final message
		  return Arrays.toString(items)+" are purchased having prices:"+Arrays.toString(prices)+" with bill amount"+billamt+"....."+msg;
		
	}

}
