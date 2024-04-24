package com.dailycodebuffer.demo.models;

import java.time.Instant;

import com.dailycodebuffer.demo.enums.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

	private long orderId;
	private Instant orderDate;
	private String orderStatus;
	private long amount;
	private ProductDetails productDetails;
	private PaymentDetails paymentDetails;
	
	@Data
	@Builder
	public static class ProductDetails {
		private String productName;
		private long productId;
		private long price;
	}
	
	@Data
	@Builder
	public static class PaymentDetails {

		private long paymentId;
		private String status;
		private PaymentMode paymentMode;
		private long amount;
		private Instant paymentDate;
		private long orderId;
	}
	
}