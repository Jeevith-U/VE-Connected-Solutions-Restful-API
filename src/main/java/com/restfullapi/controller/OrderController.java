package com.restfullapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfullapi.dto.OrderDto;
import com.restfullapi.entity.Orders;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService ;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService ;
	}
	
	@PostMapping("/orders")
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders orders){
		return orderService.saveOrder(orders) ;
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<OrderDto>> findOrder(@PathVariable String id){
		
		return orderService.findOrder(id) ;
	}
	
	@GetMapping("/users/{id}/orders")
	public ResponseEntity<ResponseStructure<List<Orders>>> findUsersOrder(@PathVariable String id){
		
		return orderService.getUsersOrder(id) ;
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Orders>> updateOder(@RequestBody Orders orders, @PathVariable String id){
		
		return orderService.updateOrder(orders, id) ;
		
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteOrder(@RequestBody Orders orders, @PathVariable String id){
		
		return orderService.deleteOrder(orders, id) ;
	}
}

