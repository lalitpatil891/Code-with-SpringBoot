package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Vehicle;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create  IOC Container
		AnnotationConfigApplicationContext  ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get  target Spring Bean class obj ref
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invoke the method
	  vehicle.journey("hyd","goa");
	  
	  //close the IOC container
	  ctx.close();
		
		
		

	}

}
