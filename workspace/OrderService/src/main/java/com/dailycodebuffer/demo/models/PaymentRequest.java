package com.dailycodebuffer.demo.models;

import com.dailycodebuffer.demo.enums.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
	
	private long orderId;
	private long amount;
	private String referenceNumber;
	PaymentMode paymentMode;

}
