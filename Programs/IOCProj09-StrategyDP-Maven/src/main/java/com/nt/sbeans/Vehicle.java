//Vehicle.java
package com.nt.sbeans;

import javax.xml.stream.events.EndElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {

    private final PetrolEngine pEngine;
	@Autowired
	@Qualifier("pEngine")
	private IEngine  engine;  //HAS-A property

    Vehicle(PetrolEngine pEngine) {
        this.pEngine = pEngine;
    }
	
	//b.method
	public   void   journey(String startPlace,String destPlace) {
		System.out.println("Journey started from ::"+startPlace);
		engine.startEngine();
		
		System.out.println("-----Journey  is  going on--from "+startPlace+"  to "+destPlace+"------------");
		
		System.out.println("Jounery  stopped  at ::"+destPlace);
		engine.stopEngine();
		
	}

}
