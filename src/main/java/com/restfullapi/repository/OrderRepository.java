package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Orders;

/**
 * This Interface will help to Create All the Needed CRUD Operation on Order
 */
public interface OrderRepository extends JpaRepository<Orders, String> {

}

