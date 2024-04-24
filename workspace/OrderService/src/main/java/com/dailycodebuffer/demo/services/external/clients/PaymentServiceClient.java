package com.dailycodebuffer.demo.services.external.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dailycodebuffer.demo.models.PaymentRequest;

@FeignClient(name = "PAYMENTSERVICE/payment")
public interface PaymentServiceClient {
	
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

}
