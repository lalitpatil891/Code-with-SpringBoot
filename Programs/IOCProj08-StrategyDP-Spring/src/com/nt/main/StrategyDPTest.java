package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.comps.Flipkart;
import com.nt.config.AppConfig;

public class StrategyDPTest {

	public static void main(String[] args) {
		System.out.println("StrategyDPTest.main() (start)");
		 //create  IOC container
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//get access to target  Spring Bean class obj  ref
		Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
		//invoke  the b.method
		try {
			String msg=fpkt.shopping(new String[] { "shirt", "hat","watch"  },
					                                          new double[] {3333.0,555.0,5555.0});
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("StrategyDPTest.main() (end)");
		
		

	}

}
