package com.dailycodebuffer.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.demo.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
