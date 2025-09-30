package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main Spring Boot application class.
 * @EnableCaching enables Spring's caching support, which integrates with Redis via configuration.
 */

@SpringBootApplication
@EnableCaching
public class BootRestRedisCacheProj01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootRestRedisCacheProj01Application.class, args);
	}

}
