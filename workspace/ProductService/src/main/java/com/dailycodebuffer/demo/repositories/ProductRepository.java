package com.dailycodebuffer.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
