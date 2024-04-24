package com.dailycodebuffer.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.demo.models.ProductRequest;
import com.dailycodebuffer.demo.models.ProductResponse;
import com.dailycodebuffer.demo.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	
	private ProductService productService;
	
	@PostMapping
	private ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<ProductResponse> getProductById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, 
													@RequestParam("quantity") long quantity) {
		
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}