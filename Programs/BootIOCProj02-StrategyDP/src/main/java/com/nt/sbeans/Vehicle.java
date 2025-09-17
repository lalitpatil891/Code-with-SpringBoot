package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	@Autowired
	@Qualifier("dEngine")
	private IEngine engg;
	
	public  void  journery(String startPlace,String endPlace) {
		System.out.println("Vehicle.journery() (Jounery Started at::)"+startPlace);
		engg.startEngine();
		
		System.out.println("Jounery is  going on ...");
		
		engg.endEngine();
		System.out.println("Vehicle.journery() (Jounery stopped at::)"+endPlace);
	}

}
