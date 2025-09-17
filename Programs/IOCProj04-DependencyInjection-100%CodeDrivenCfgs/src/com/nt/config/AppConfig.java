//AppConfig.java
package com.nt.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	// configure pre-defined java class as spring bean using @Bean method
	//@Bean(name="ldate")
	@Bean
	public   LocalDate  createLocalDate() {
		System.out.println("AppConfig.createLocalDate()");
		return LocalDate.now();
	}

}
