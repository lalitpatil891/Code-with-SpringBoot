//Vehicle.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {

    private final PetrolEngine pEngine;
	//@Qualifier("${engg.id}")  --->invalid-- becoz place holders  can not be placed with out @Value annotaiton
	//@Qualifier(@Value("${engg.id}"))// invalid -- becoz  @Value annotation can not be merged with another annotation
	/*	@Value("${engg.id}")
		private String id;
		@Qualifier(id)  //invalid  becoz  variable  can not be passed in the @Qualifier annotation
	*/	
    @Autowired
    @Qualifier("motor")
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
