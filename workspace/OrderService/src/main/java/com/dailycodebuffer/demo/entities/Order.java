package com.dailycodebuffer.demo.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ORDER_DETAILS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_ID")
	private long id;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="QUANTITY")
	private long quantity;
	
	@Column(name = "ORDER_DATE")
	private Instant orderDate;
	
	@Column(name ="ORDER_STATUS")
	private String orderStatus;
	
	@Column(name = "AMOUNT")
	private long amount;
}
