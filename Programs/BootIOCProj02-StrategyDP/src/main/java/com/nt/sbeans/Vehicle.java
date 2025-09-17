//Vehicle.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {
	
	@Autowired
	@Qualifier("pEngg")
	private  IEngine engg;
	
	//b.method
	public  void  journey(String startPlace,String endPlace) {
		System.out.println("Journery started at ::"+startPlace);
		engg.startEngine();
		System.out.println("Jouenry is going on......");
		engg.stopEngine();
		System.out.println("Journery ended at ::"+endPlace);
	}

}
