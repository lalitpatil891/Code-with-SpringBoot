//AppConfig.java
package com.nt.config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	// configure pre-defined java class as spring bean using @Bean method
	@Bean(name="ldate1")
	@Primary
	public   LocalDate  createLocalDate1() {
		System.out.println("AppConfig.createLocalDate1()");
		return LocalDate.now();
	}
	
	@Bean(name="ldate2")
	//@Primary
	public   LocalDate  createLocalDate2() {
		System.out.println("AppConfig.createLocalDate2()");
		return LocalDate.of(2000,10,20);
	}
	
	@Bean(name="ldate3")
	public   LocalDate  createLocalDate3() {
		System.out.println("AppConfig.createLocalDate3()");
		return LocalDate.of(2001, 10, 20);
	}
	
	//@Bean(name="ldate4")
	@Bean(name="date")
	public   LocalDate  createLocalDate4() {
		System.out.println("AppConfig.createLocalDate4()");
		return LocalDate.of(2002, 10, 20);
	}
	
	
	
	@Bean(name="ltime")
	public    LocalTime  createLocalTime() {
		System.out.println("AppConfig.createLocalTime()");
		return LocalTime.now();
	}

}
