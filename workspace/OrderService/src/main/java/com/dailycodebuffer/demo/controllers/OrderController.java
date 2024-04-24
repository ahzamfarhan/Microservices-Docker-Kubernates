package com.dailycodebuffer.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.demo.models.OrderDto;
import com.dailycodebuffer.demo.models.OrderResponse;
import com.dailycodebuffer.demo.services.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Log4j2
public class OrderController {
	
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		
		log.info("");
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
		
		log.info("");
		return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("orderId") long orderId) {
		
		log.info("");
		return new ResponseEntity<>(orderService.getOrderDetails(orderId), HttpStatus.CREATED);
	}
	
}