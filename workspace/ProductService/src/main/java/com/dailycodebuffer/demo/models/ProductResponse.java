package com.dailycodebuffer.demo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProductResponse {
	private String productName;
	private long productId;
	private long price;
}
