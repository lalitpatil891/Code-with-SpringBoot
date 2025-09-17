//FactoryBeanTest.java
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.Vehicle;

public class FactoryBeanTest {

	public static void main(String[] args) {
		//create  IOC container
		 AnnotationConfigApplicationContext  ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		 //get  Spring Bean class obj  ref
		 Vehicle  vehicle=ctx.getBean("vehicle",Vehicle.class);
		 //invoke the b.method
		 vehicle.journey("hyd", "vooty");
		 
		 System.out.println("==========================");
		 IEngine  engg=ctx.getBean("eFactory",IEngine.class);
		 System.out.println("engg type::"+engg.getClass());
		 
		 //close the container
		 ctx.close();

	}

}
