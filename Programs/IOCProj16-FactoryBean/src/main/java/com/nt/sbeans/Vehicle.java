//Vehicle.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {

	@Autowired
	private IEngine  engine;  //HAS-A property

	
	//b.method
	public   void   journey(String startPlace,String destPlace) {
		System.out.println("Journey started from ::"+startPlace);
		engine.startEngine();
		
		System.out.println("-----Journey  is  going on--from "+startPlace+"  to "+destPlace+"------------");
		
		System.out.println("Jounery  stopped  at ::"+destPlace);
		engine.stopEngine();
		
	}

}
