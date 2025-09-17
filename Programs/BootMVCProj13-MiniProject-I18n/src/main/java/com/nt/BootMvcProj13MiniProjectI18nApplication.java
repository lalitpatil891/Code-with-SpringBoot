package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj13MiniProjectI18nApplication {
	
	@Bean(name="localeResolver")  //fixed bean id
	public    SessionLocaleResolver  createLocaleResolver() {  // To activate i18n on the whole App
		SessionLocaleResolver  resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
	}
	
	@Bean(name="lci")
	public    LocaleChangeInterceptor  createLCI() {  // To trap request and to enable Locale on each request
		  LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		  interceptor.setParamName("lang");
		  return  interceptor;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj13MiniProjectI18nApplication.class, args);
	}

}
