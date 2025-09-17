package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	@Bean(name="messageSource")  //fixed  bean id
	public ResourceBundleMessageSource  createRBMS() {
		//create ResourceBundleMEssageSource object
		ResourceBundleMessageSource  messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("com/nt/commons/myfile"); // the base file name and locaton
		return messageSource;
	}

}
