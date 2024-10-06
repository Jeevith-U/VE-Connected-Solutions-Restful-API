package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

}
