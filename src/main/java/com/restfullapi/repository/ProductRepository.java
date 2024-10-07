package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Product;

/**
 * This Interface will help to All the Needed CRUD Operation on Product
 */
public interface ProductRepository extends JpaRepository<Product, String> {

}
