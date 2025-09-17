//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nt.ston.Printer;

@Configuration
//@ComponentScan(basePackages = {"com.nt.sbeans","com.nt.ston"})
@ComponentScan(basePackages = "com.nt")
public class AppConfig {
	
	
	@Bean(name="prn1")
	@Scope("prototype")
	public   Printer  createPrinter1() {
	  return  Printer.getInstance();	
	}
	
	@Bean(name="prn2")
	@Scope("prototype")
	public  Printer  createPrinter2() {
		return  Printer.getInstance();
	}
	

}
