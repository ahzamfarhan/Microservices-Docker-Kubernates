package com.dailycodebuffer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.dailycodebuffer.demo.controllers", 
								"com.dailycodebuffer.demo.services",
								"com.dailycodebuffer.demo.advice"})
@EntityScan(basePackages = {"com.dailycodebuffer.demo.entities"})
@EnableJpaRepositories(basePackages = {"com.dailycodebuffer.demo.repositories"})
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}