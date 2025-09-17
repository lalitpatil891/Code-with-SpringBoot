package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
			//Create IOC container 
			ApplicationContext context = new FileSystemXmlApplicationContext("src/com/example/config/ApplicationContext.xml");
			
			//ApplicationContext context = new FileSystemXmlApplicationContext("D:/spring-config/ApplicationContext.xml"); //When to use FileSystemXmlApplicationContext (for config files outside the classpath).
			
			//Get bean 
			MyBean bean = context.getBean(MyBean.class);
			
			bean.sayHello();
	}
}