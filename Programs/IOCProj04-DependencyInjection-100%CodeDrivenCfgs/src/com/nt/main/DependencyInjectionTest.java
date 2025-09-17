package com.nt.main;

import java.time.LocalDate;
import java.util.Arrays;

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
		//WeekDayFinder  wdf=ctx.getBean("wdf",WeekDayFinder.class);
		WeekDayFinder  wdf=ctx.getBean("weekDayFinder",WeekDayFinder.class);
		//invoke the b.method
		String msg=wdf.showGreetingMessage("rani");
		System.out.println("result::"+msg);
		System.out.println("=========================");
		LocalDate  date=ctx.getBean("createLocalDate",LocalDate.class);
		System.out.println(date);
		
		
		System.out.println("all bean ids ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		
		
		//close the IOC container
		ctx.close();

		System.out.println("DependencyInjectionTest.main() (end)");
	}//main

}//class
