package com.restfullapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dto.OrderDto;
import com.restfullapi.entity.Orders;
import com.restfullapi.responseStructure.ResponseStructure;

@Service
public interface OrderService {
	
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders orders) ;
	
	public ResponseEntity<ResponseStructure<OrderDto>> findOrder(String id) ;
	
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders orders, String id) ;
	
	public ResponseEntity<ResponseStructure<Boolean>> deleteOrder(Orders orders, String id) ;
	
	public ResponseEntity<ResponseStructure<List<Orders>>> getUsersOrder(String userId) ;
}
