package com.dailycodebuffer.demo.models;

import java.time.Instant;

import com.dailycodebuffer.demo.enums.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

	private long id;
	private long productId;
	private long quantity;
	private Instant orderDate;
	private String orderStatus;
	private long amount;
	private PaymentMode paymentMode;
}
