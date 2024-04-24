package com.dailycodebuffer.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.demo.entities.Order;
import com.dailycodebuffer.demo.enums.PaymentMode;
import com.dailycodebuffer.demo.exceptions.OrderServiceException;
import com.dailycodebuffer.demo.models.OrderDto;
import com.dailycodebuffer.demo.models.OrderResponse;
import com.dailycodebuffer.demo.models.OrderResponse.ProductDetails;
import com.dailycodebuffer.demo.models.PaymentRequest;
import com.dailycodebuffer.demo.repositories.OrderRepository;
import com.dailycodebuffer.demo.services.external.clients.PaymentServiceClient;
import com.dailycodebuffer.demo.services.external.clients.ProductServiceClient;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@AllArgsConstructor
@Log4j2
@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	private ProductServiceClient productServiceClient;
	
	private PaymentServiceClient paymentServiceClient;
	
	private RestTemplate restTemplate;
	
	
	public List<OrderDto> getAllOrders() {
		
		log.info("");
		
		return orderRepository.findAll()
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	public OrderDto getOrderById(long orderId) {
		
		log.info("");
		return orderRepository.findById(orderId)
				.map(this::convertToDto)
				.orElseThrow(()-> new RuntimeException(""));
	}
	
	public OrderDto createOrder(OrderDto orderDto) {
		
		log.info("placing order");
		
		 //Calling ProductService microservice using Feign Client.
		 productServiceClient.reduceQuantity(orderDto.getProductId(), orderDto.getQuantity());

		 Order order = orderRepository.save(convertToEntity(orderDto));
		 orderDto.setId(order.getId());
		 
		 log.info("Doing payment");
		 
		 
		 String orderStatus = "";
		 try {
		
			 //Calling Payment Microservice using RestTemplate.
			 paymentServiceClient.doPayment(convertToPaymentRequest(orderDto));
			 
			 orderStatus = "PLACED";
			 log.info("Payment done");
			 
		 } catch (Exception e) {
			 log.info("Payment failed");
			 orderStatus = "FAILED";
		 }
		 
		 order.setOrderStatus(orderStatus);
		 
		return convertToDto(orderRepository.save(order));
		
	}
	
	public OrderResponse getOrderDetails(long orderId) {

		log.info("Getting order detail...");
		
		Order order = orderRepository.findById(orderId)
				.orElseThrow(()-> new OrderServiceException(
						String.format("Order not found for the orderId: %s", orderId), "NOT FOUND"));
							
		ProductDetails productDetails = restTemplate.getForObject(
												"http://PRODUCTSERVICE/product/" 
												 + order.getProductId(), OrderResponse.ProductDetails.class);
	
		OrderResponse.PaymentDetails paymentDetails = restTemplate.getForObject("http://PAYMENTSERVICE/payment/" 
														+ order.getId(), OrderResponse.PaymentDetails.class);
		
		
		OrderResponse orderResponse =  convertToResponse(order, productDetails, paymentDetails);
		
		return orderResponse;
	}
	
	private PaymentRequest convertToPaymentRequest(OrderDto orderDto) {
		
		return  PaymentRequest
			 	.builder()
			 	.amount(orderDto.getAmount())
			 	.orderId(orderDto.getId())
			 	.paymentMode(orderDto.getPaymentMode())
			 	//.referenceNumber("")
			 	.build();
	}
	
	private OrderDto convertToDto(Order order) {
		
		return OrderDto
				.builder()
				.amount(order.getAmount())
				.orderDate(order.getOrderDate())
				.orderStatus(order.getOrderStatus())
				.productId(order.getProductId())
				.id(order.getId())
				.quantity(order.getQuantity())
				.build();
	}
	
	
	
	private Order convertToEntity(OrderDto orderDto) {
		
		return Order
				.builder()
				.amount(orderDto.getAmount())
				.orderDate(orderDto.getOrderDate())
				.orderStatus(orderDto.getOrderStatus())
				.productId(orderDto.getProductId())
				.id(orderDto.getId())
				.quantity(orderDto.getQuantity())
				.build();
	}
	
	private OrderResponse convertToResponse(Order order, ProductDetails productDetails, OrderResponse.PaymentDetails paymentDetails) {
		
		return OrderResponse.builder()
							.amount(order.getAmount())
							.orderDate(order.getOrderDate())
							.orderStatus(order.getOrderStatus())
							.orderId(order.getId())
							.productDetails(productDetails)
							.paymentDetails(paymentDetails)
							.build();
		
	}
}