package com.dailycodebuffer.demo.services;

import com.dailycodebuffer.demo.models.ProductRequest;
import com.dailycodebuffer.demo.models.ProductResponse;

public interface ProductService {
	
	public long addProduct(ProductRequest productRequest);
	public ProductResponse getProductById(long id);
	public void reduceQuantity(long productId, long quantity);

}
