package com.epam.resourceProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
@EnableEurekaClient
public class ResourceProcessorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResourceProcessorApplication.class, args);
	}
}