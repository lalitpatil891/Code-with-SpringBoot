package com.nt;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01FirstAppApplication {
	
	@Bean(name="ldt")
	public  LocalDate  createLDT() {
		System.out.println("BootIocProj01FirstAppApplication.createLDT()");
		return LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println("BootIocProj01FirstAppApplication.main() (start)");
		//get access to IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj01FirstAppApplication.class, args);){
		System.out.println("ctx obj class name::"+ctx.getClass());
		//get target spring bean class obj ref
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		String resultMsg=finder.showSeason();
		System.out.println("Season Name ::"+resultMsg);
		
		System.out.println("  Spring Beans Count ::"+ctx.getBeanDefinitionCount());
		System.out.println(" All Bean ids are ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("BootIocProj01FirstAppApplication.main() (end)");
	}//main

}//class
