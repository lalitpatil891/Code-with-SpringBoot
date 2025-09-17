package com.nt.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.SeasonFinder;

public class DependencyInjectionTest {

	public static void main(String[] args) {

		System.out.println("DependencyInjectionTest.main()---> [START]");

		// Create IoC Container
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/nt/config/applicationContext.xml");) {

			// get Target Spring bean class obj ref
			SeasonFinder season = ctx.getBean("sf", SeasonFinder.class);

			// invoked the b.method
			String msg = season.showSeasonName();
			System.out.println(msg);
			
			System.out.println("=========================");
			
			System.out.println("Spring Beans count::"+ctx.getBeanDefinitionCount());
			System.out.println("Spring Bean Defination names/ids::"+Arrays.toString(ctx.getBeanDefinitionNames()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch end

		System.out.println("DependencyInjectionTest.main()---> [END]");
	}// main
	
}// class

/*
OUTPUT-->

DependencyInjectionTest.main()---> [Start]
SeasonFinder:: 0-param constructor
SeasonFinder.setDate()
SeasonFinder.ShowSeasonName()
Rainy Season
=========================
Spring Beans count::6
Spring Bean Defination names/ids::[sf, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, Idate]

*/