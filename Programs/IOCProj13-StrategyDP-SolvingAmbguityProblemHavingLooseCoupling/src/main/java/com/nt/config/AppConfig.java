//AppConfig.java
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
@ImportResource("com/nt/cfgs/applicationContext.xml")  //links  given xml file with configuration class
public class AppConfig {
	

}
