package com.nt.main;

import com.nt.comps.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		System.out.println("StrategyDPTest.main() (start)");
		//get  Flipkart class object
		Flipkart fpkt=FlipkartFactory.getInstance("dtdc");
		//invoke the b.methods
		String  msg=fpkt.shopping(new String[] {"shirt", "trouser","watch"}
		                                                      , new double[] {4000.0,5000.0,12000.0});
		System.out.println(msg);
		
		System.out.println("StrategyDPTest.main() (end)");
		
		

	}

}
