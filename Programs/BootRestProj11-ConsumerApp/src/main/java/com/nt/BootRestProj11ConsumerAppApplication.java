package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootRestProj11ConsumerAppApplication {
	
	@Bean(name="template")
	public  RestTemplate  createTemplate() {
		System.out.println("BootRestProj11ConsumerAppApplication.createTemplate()");
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootRestProj11ConsumerAppApplication.class, args);
	}

}
