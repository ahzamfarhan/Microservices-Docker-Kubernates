package com.dailycodebuffer.demo.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dailycodebuffer.demo.exceptions.OrderServiceException;
import com.dailycodebuffer.demo.models.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<ErrorResponse> handleOrderServiceException(OrderServiceException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), ex.getStatusCode()), HttpStatus.BAD_REQUEST);
		
	}

}
