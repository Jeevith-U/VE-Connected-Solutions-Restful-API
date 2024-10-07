package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
