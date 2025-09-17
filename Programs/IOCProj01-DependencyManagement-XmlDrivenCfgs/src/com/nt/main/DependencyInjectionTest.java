//DependencyInjectionTest.java  (main class)
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.ston.Printer;

public class DependencyInjectionTest {
	
	public static void main(String[] args) {
		System.out.println("DependencyInjectionTest.main() (start )");
		
		/*	ClassPathXmlApplicationContext  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			
			//get Spring bean class obj ref
			  WishMessageGenerator generator=ctx.getBean("com.nt.sbeans.WishMessageGenerator#0",WishMessageGenerator.class);
			  
			   //invoke the b.method
			  String msg=generator.showWishMessage("raja");
			     System.out.println(msg);
			     
			     System.out.println("======================");
			     System.out.println("spring beans count ::"+ctx.getBeanDefinitionCount());
			     System.out.println("Bean ids :"+Arrays.toString(ctx.getBeanDefinitionNames()));
			     
		*/	
		
		ClassPathXmlApplicationContext  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Printer prn1=ctx.getBean("prn1",Printer.class);
		Printer prn11=ctx.getBean("prn1",Printer.class);
		Printer prn2=ctx.getBean("prn2",Printer.class);
		Printer prn22=ctx.getBean("prn2",Printer.class);
		System.out.println(prn1.hashCode()+"  "+prn11.hashCode()+"  "+prn2.hashCode()+"  "+prn22.hashCode());
		
		
		
		     
		     //close container
		     ctx.close();
		     System.out.println("DependencyInjectionTest.main() (end)"); 
		}

}
