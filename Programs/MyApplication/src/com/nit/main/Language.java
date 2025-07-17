package com.nit.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.beans.Java;

public class Language {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/nit/config/beans.xml");) {
			
		//get target Spring class obj
		Java j = ctx.getBean("java", Java.class);	
			
		j.getJava();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
