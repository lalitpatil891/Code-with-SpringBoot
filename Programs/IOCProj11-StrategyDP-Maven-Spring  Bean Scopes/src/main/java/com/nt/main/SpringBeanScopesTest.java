package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Vehicle;
import com.nt.ston.Printer;

public class SpringBeanScopesTest {

	public static void main(String[] args) {
		//create  IOC Container
		AnnotationConfigApplicationContext  ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		/*//get target spring bean class obj refs
		  Vehicle vehicle1=ctx.getBean("vehicle",Vehicle.class);
		  Vehicle vehicle2=ctx.getBean("vehicle",Vehicle.class);
		  System.out.println(vehicle1.hashCode()+"  "+vehicle2.hashCode());
		  System.out.println("vehicle1==vehicle2?"+(vehicle1==vehicle2));*/
		
		/*	Printer printer1=ctx.getBean("printer",Printer.class);
			Printer printer2=ctx.getBean("printer",Printer.class);
			System.out.println(printer1.hashCode()+"  "+printer2.hashCode());*/
		/*Printer prn1=ctx.getBean("prn1",Printer.class);
		Printer prn11=ctx.getBean("prn1",Printer.class);
		Printer prn2=ctx.getBean("prn2",Printer.class);
		Printer prn22=ctx.getBean("prn2",Printer.class);
		System.out.println(prn1.hashCode()+"  "+prn11.hashCode()+"  "+prn2.hashCode()+" "+prn22.hashCode());
		*/
		
		
	Vehicle  v1=ctx.getBean("vehicle",Vehicle.class);
		Vehicle  v2=ctx.getBean("vehicle",Vehicle.class);
		Vehicle  v3=ctx.getBean("vehicle",Vehicle.class);
		System.out.println(v1.hashCode()+"  "+v2.hashCode()+" "+v3.hashCode());
		
		
		/*	Printer p1=ctx.getBean("printer",Printer.class);
			Printer  p2=ctx.getBean("printer",Printer.class);
			System.out.println(p1.hashCode()+"  "+p2.hashCode());*/
		
		/*  Printer prn1=ctx.getBean("prn1",Printer.class);
		  Printer prn11=ctx.getBean("prn1",Printer.class);
		  Printer prn2=ctx.getBean("prn2",Printer.class);
		  Printer prn21=ctx.getBean("prn2",Printer.class);
		  System.out.println(prn1.hashCode()+"  "+prn11.hashCode()+"  "+prn2.hashCode()+" "+prn21.hashCode());
		*/  
		  
		
		   
		
		
		
		
		  
	  
	  //close the IOC container
	  ctx.close();
		
		
		

	}

}
