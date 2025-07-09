package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.sbeans.Cricket;

public class Main {

	public static void main(String[] args) {
		
		//Create IOC Container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml");
		
		//get Bean
		Cricket cricket =ctx.getBean("cricket", Cricket.class );
				
				
		cricket.displayScore();
		
	}

}
