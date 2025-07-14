package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.sbeans.A;
import com.nit.sbeans.B;

public class CyclicInjectionTest {

	public static void main(String[] args) {
		
		//create the IOC container
		try(FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml");){  //try with resource java 7 feature
		
		//get Spring bean class obj ref
		A a = (A)ctx.getBean("a1");
		System.out.println("a= "+a);
		
		System.out.println("=====================");
		
		B b = (B) ctx.getBean("b1");
		System.out.println("b=" +b);
		} //try -> Since IOC container is AutoClosebale obj and  			created indide try with resource, 
			// So it will be closed here automatically
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

/*Output

Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'b1' defined in file [D:\@Java Placement Course\Spring Boot & Microservices\Code-with-SpringBoot\Programs\IOCProj4-cyclicDI-ConstructorInjection\src\com\nit\config\ApplicationContext.xml]: Cannot resolve reference to bean 'a1' while setting constructor argument
*/