//PetrolEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

//@Component("pEngine")
public class PetrolEngine implements  IEngine {
	

	@Override
	public void startEngine() {
		System.out.println("PetrolEngine.startEngine() ");
		
	}
	
	@Override
	public void endEngine() {
	  System.out.println("PetrolEngine.endEngine()");	
	}
}
