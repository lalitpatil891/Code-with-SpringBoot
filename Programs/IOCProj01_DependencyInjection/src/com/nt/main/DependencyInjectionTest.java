package com.nt.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {

	public static void main(String[] args) {

		// Create IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/com/nt/cfgs/applicationContext.xml");

		// get target spring bean class obj ref
		Object obj = ctx.getBean("wmg");

		// typecasting
		WishMessageGenerator generator = (WishMessageGenerator) obj;

		// invoke the b.method
		String result = generator.showWishMessage("Raja");

		System.out.println(result);

		// close the IOC container

		ctx.close();

	}

}
