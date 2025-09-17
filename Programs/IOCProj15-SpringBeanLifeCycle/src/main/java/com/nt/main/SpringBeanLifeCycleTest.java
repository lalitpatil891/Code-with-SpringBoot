package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.VotingElgibilityCheck;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		//create  IOC Container 
		AnnotationConfigApplicationContext  ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//get Spring Bean class obj ref
		 VotingElgibilityCheck  check=ctx.getBean("vec",VotingElgibilityCheck.class);
		 //invoke the method
		 String  msg=check.findVotingElgibilty();
		 System.out.println(msg);
		 
		 //close the IOC container
		ctx.close();

	}

}
