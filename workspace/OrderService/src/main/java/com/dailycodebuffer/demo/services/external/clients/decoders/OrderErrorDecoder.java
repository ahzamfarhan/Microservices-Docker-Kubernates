package com.dailycodebuffer.demo.services.external.clients.decoders;


import java.io.IOException;

import com.dailycodebuffer.demo.exceptions.OrderServiceException;
import com.dailycodebuffer.demo.models.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderErrorDecoder implements ErrorDecoder{

	public OrderErrorDecoder() {
		System.out.println("DECODER CONSTRUCTOR ###");
		log.info("LOG---> DECODER");
	}
	
	@Override
	public Exception decode(String methodKey, Response response) {

		log.info("method key: %s%n Status : %s%n Reason %s%n", methodKey, response.status(), response.reason());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		ErrorResponse errorResponse;
			try {
				
				errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
				
				return new OrderServiceException(errorResponse.getErrorMessage(), errorResponse.getErrorCode());
				
			} catch (IOException ex) {
				
				return new OrderServiceException(ex.getMessage(), "INTERNAL IO SERVER ERROR");
				
			}
		
		
	}

}
