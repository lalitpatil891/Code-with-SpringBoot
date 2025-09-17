package com.nit.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.config.AppConfig;
import com.nit.sbeans.WeekDayFinder;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		
		//Create IoC Container
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);)
		{
			
			//Get Target spring bean class obj ref
			WeekDayFinder finder = ctx.getBean("wf", WeekDayFinder.class);
			
			//invoke the b.method
			System.out.println("Result::"+finder.showGreetMessage("raja"));
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main

}//class
