package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootIocProj02StrategyDpApplication {

	public static void main(String[] args) {
		 //get Access to IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj02StrategyDpApplication.class, args);
		//get Spring Bean class obj ref
		Vehicle  vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invoke the method
		vehicle.journery("hyd", "mahabhalleswar");
		
		//close  the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
