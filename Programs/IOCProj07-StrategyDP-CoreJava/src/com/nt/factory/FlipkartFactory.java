//FlipkartFactory.java (Factory Pattern class)
package com.nt.factory;

import com.nt.comps.BlueDart;
import com.nt.comps.DTDC;
import com.nt.comps.Flipkart;
import com.nt.comps.ICourier;

public class FlipkartFactory {
	
	//factory method
	public static  Flipkart getInstance(String courierName) {
		System.out.println("FlipkartFactory.getInstance()");
		  //create  dependent class object
		ICourier  courier=null;
		if(courierName.equalsIgnoreCase("dtdc"))
			courier=new DTDC();
		else if(courierName.equalsIgnoreCase("bDart"))
			courier=new BlueDart();
		else
			throw new IllegalArgumentException("Invalid courier name");
		 //create target class object
		Flipkart  fpkt=new Flipkart();
		//set dependent class obj to target  class object
		fpkt.setCourier(courier);
		return fpkt;
		
	}

}
