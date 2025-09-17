package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj01SearchServiceMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01SearchServiceMs1Application.class, args);
	}

}
