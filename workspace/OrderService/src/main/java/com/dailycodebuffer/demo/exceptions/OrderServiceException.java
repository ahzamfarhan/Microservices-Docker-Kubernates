package com.dailycodebuffer.demo.exceptions;

import lombok.Getter;

@Getter
public class OrderServiceException extends RuntimeException {

	private String statusCode;
	
	public OrderServiceException(String message, String statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
