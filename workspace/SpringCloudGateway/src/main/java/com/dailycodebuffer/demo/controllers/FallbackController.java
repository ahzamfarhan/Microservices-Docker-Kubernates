package com.dailycodebuffer.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	
	@GetMapping("/orderServiceFallBack")
	public String orderServiceFallbackHandler() {
		return "Order Service is down";
	}
	
	@GetMapping("/productServiceFallBack")
	public String producterviceFallbackHandler() {
		return "Product Service is down";
	}
	
	@GetMapping("/paymentServiceFallBack")
	public String paymentServiceFallBack() {
		return "Payment Service is down";
	}
}
