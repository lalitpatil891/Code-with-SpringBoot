//Vehicle.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Component("vehicle")
@Service("vehicle")
//@Scope("prototype")
//@Scope("request")
//@Lazy(true)
public final class Vehicle {

   @Autowired
	@Qualifier("pEngine")
	private IEngine  engine;  //HAS-A property

   public Vehicle() {
	System.out.println("Vehicle:: 0-param constructor");
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
