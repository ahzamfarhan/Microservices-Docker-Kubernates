package com.dailycodebuffer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}


	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {

		return factory -> factory.configureDefault(
	                                     id -> new Resilience4JConfigBuilder(id)
	                                            .circuitBreakerConfig(
	                                                 CircuitBreakerConfig.ofDefaults()
	                                            ).build());
	}
	
	
	/*
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		
		return factory -> factory.configureDefault(
										id -> {
											
											System.out.println("@@@@----#####&&&&----: -> id :- " + id);
		
											var r = new Resilience4JConfigBuilder(id)
												  	.circuitBreakerConfig(
												  			CircuitBreakerConfig.ofDefaults()
												  	).build();
												  	
											return r;	
												  	
										});
		
	}
	*/
	
	
	/*
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		
		return factory -> factory.configureDefault(
										id -> new Resilience4JConfigBuilder(id)
												  	.circuitBreakerConfig(
												  			CircuitBreakerConfig.ofDefaults()
												  	).build()
												  	
				
								 );
	}
	*/
	
	
	/*
	 @Bean
	    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
	        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
	                .circuitBreakerConfig(CircuitBreakerConfig.custom().minimumNumberOfCalls(5).failureRateThreshold(20).build())
	                .build());
	    }
	    */
}