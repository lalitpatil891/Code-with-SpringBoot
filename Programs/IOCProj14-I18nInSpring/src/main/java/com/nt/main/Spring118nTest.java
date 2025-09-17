package com.nt.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class Spring118nTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=
				  new AnnotationConfigApplicationContext(AppConfig.class);
		
		//read language and  country code from the end user
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter language code::");
		String lang=sc.next();
		System.out.println("Enter  country code::");
		String country=sc.next();
		
		//create Locale object having country code and language code
		Locale locale=new Locale(lang,country);
		
		//get messages from Locale Specific properties file
		String msg1=ctx.getMessage("welcome.msg",new String[] {"students"}," msg1",locale);
		String msg2=ctx.getMessage("goodbye.msg",new String[] {  }," msg2",locale);
		String msg3=ctx.getMessage("gap.msg",new String[] {  }," msg3",locale);
		String msg4=ctx.getMessage("end.msg",new String[] {  }," msg4",locale);
		System.out.println(msg1+" ... "+msg2+".. "+msg3+" ...  "+msg4);
		
		//close the Container
		ctx.close();
	}//main

}//class
