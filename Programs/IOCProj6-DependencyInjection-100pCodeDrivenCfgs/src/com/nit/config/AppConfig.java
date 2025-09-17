package com.nit.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.nit.sbeans")
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig:: 0-param Constructor");
	}
	
	@Bean(name="ldate")
	public LocalDate createLDate() {
		System.out.println("AppConfig.createDate()");
		return LocalDate.now();
	}
	
	//	@Primary
		@Bean(name="ldate1") 
		public LocalDate createLDate1() {
			System.out.println("AppConfig.createDate1()");
			return LocalDate.of(2020,10,24);
		}
	/*	
		// Place @Primary on one of the multiple same type dependent Spring beans
		// To tell Spring's IoC container:
		// “Use this bean first if multiple beans of same type are found.”
	*/
}
