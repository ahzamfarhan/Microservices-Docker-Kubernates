package com.dailycodebuffer.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dailycodebuffer.demo.exceptions.ProductServiceCustomException;
import com.dailycodebuffer.demo.models.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductByIdNotFoundHandler(ProductServiceCustomException productServiceCustomException) {
		
		return new ResponseEntity<>(ErrorResponse.builder()
												.errorMessage(productServiceCustomException.getMessage())
												.errorCode(productServiceCustomException.getErrorCode())
												.build(), HttpStatus.NOT_FOUND);
	}
}
