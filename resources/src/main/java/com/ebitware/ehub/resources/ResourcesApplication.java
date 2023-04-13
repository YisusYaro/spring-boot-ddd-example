package com.ebitware.ehub.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ebitware.ehub")
public class ResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcesApplication.class, args);
	}

}
