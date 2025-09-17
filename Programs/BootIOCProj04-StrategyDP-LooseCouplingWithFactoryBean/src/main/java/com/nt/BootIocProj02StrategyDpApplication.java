package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Vehicle;

import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootIocProj02StrategyDpApplication {

	public static void main(String[] args) {
		        //create  IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj02StrategyDpApplication.class, args)){
			    //get target spring bean class obj ref
		          Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		          //invoke the b.method
		          vehicle.journey("hyd", "pune");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
