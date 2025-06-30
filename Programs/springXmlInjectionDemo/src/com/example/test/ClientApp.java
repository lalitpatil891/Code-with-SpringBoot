package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.WishMessageGenerator;

public class ClientApp {

	public static void main(String[] args) {

		// Create Spring container and load XML config
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the target bean
		WishMessageGenerator generator = ctx.getBean("WishBean", WishMessageGenerator.class);

		// Called Method
		String msg = generator.generateWish("Lalit");

		// prints the message
		System.out.println(msg);

		// close the context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}

/**
 * Spring first creates the bean using constructor injection.
 * 
 * Then calls the setter methods (overrides values).
 * 
 * Finally, your code calls generateWish.
 * 
 * In Spring, if you do constructor injection first, it sets some value.
Then if you also do setter injection, Spring sets the value again → this new value replaces (overrides) the old one.
 */
