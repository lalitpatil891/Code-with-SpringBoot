package com.nt.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.sbeans.PersonalInfo;
import com.nt.sbeans.TestProperties;

public class ValueAnnotationTets {

	public static void main(String[] args) {
		//create  IOC Container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get spring bean calss obj ref
		PersonalInfo info=ctx.getBean("pInfo",PersonalInfo.class);
		System.out.println(info);
		
		System.out.println("====================");
		Environment  env=ctx.getEnvironment();
		System.out.println("per.name key value ::"+env.getProperty("per.name"));
		System.out.println("os.name key value ::"+env.getProperty("os.name"));
		
		System.out.println("Environment obj class name::"+env.getClass());
		System.out.println("====================");
       TestProperties props=ctx.getBean("props",TestProperties.class);		
       System.out.println(props);
       
       System.out.println("===============");
       System.out.println("All  spring bean ids "+Arrays.toString(ctx.getBeanDefinitionNames()));
		
		
		
		//ctx.close();
		ctx.close();
	}

}
