package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WeekDayFinder;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		System.out.println("DependencyInjectionTest.main() (start)");
		//create  IOC container
		AnnotationConfigApplicationContext  ctx=
				          new AnnotationConfigApplicationContext(AppConfig.class);
		//get  target Spring bean class object
		WeekDayFinder  wdf=ctx.getBean("wdf",WeekDayFinder.class);
		//invoke the b.method
		String msg=wdf.showGreetingMessage("rani");
		System.out.println("result::"+msg);
		
		//close the IOC container
		ctx.close();

		System.out.println("DependencyInjectionTest.main() (end)");
	}//main

}//class
