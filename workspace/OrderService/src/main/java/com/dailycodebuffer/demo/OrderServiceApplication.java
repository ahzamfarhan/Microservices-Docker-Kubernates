package com.dailycodebuffer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.demo.services.external.clients.decoders.OrderErrorDecoder;

import feign.codec.ErrorDecoder;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.dailycodebuffer.demo.controllers", 
								"com.dailycodebuffer.demo.services",
								"com.dailycodebuffer.demo.exceptions.handlers",
								"com.dailycodebuffer.demo.services.external.clients.decoders"})
@EntityScan(basePackages = {"com.dailycodebuffer.demo.entities"})
@EnableJpaRepositories(basePackages = {"com.dailycodebuffer.demo.repositories"})
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
	public ErrorDecoder errorDecoder() {
		return new OrderErrorDecoder();
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
