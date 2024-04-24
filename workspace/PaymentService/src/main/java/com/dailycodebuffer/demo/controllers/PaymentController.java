package com.dailycodebuffer.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.demo.models.PaymentRequest;
import com.dailycodebuffer.demo.models.PaymentResponse;
import com.dailycodebuffer.demo.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

	private PaymentService paymentService;
	
	
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
		return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);		
	}
	
	@GetMapping("/{orderId}")
	private ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable(name = "orderId") long orderId) {
		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
	}
}