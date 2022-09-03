package com.bridgelabz.adminmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LmsAdminModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsAdminModuleApplication.class, args);
	}
}
