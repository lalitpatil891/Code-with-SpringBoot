package com.nt;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication {
	
	@Bean(name="date")
	public    LocalDate  createDate() {
		return  LocalDate.now();
	}

	public static void main(String[] args) {
		  // get access to IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		System.out.println("ctx obj class name::"+ctx.getClass());
		  //get target spring bean class obj  ref
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		String msg=finder.findSeason();
		System.out.println(msg);
		
		System.out.println("==================");
		String[]  beanids=ctx.getBeanDefinitionNames();
		System.out.println("Bean ids are ::"+Arrays.toString(beanids));
		
		//close the IOC container
		((AnnotationConfigApplicationContext) ctx).close();
	}

}
