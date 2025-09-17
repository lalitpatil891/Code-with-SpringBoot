//CyclicDITest.java
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.A;

public class CyclicInjectionTest {

	public static void main(String[] args) {
		//create  IOC container
		ClassPathXmlApplicationContext ctx=
				                      new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get spring bean class obj ref
		 A  a1=ctx.getBean("a1",A.class);
		 System.out.println(a1);
		 
		 //close IOC container
		 ctx.close();

	}

}
