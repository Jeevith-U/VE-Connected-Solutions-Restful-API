package com.restfullapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restfullapi.entity.Orders;
import com.restfullapi.repository.OrderRepository;

@Repository
public class OrderDao {
	
	private OrderRepository orderRepository;

	@Autowired
	public OrderDao(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	/**
	 * Saves a new order to the database.
	 *
	 * @param orders the order to save
	 * @return the saved order
	 */
	public Orders saveOrder(Orders orders) {
		return orderRepository.save(orders);
	}
	
	/**
	 * Retrieves an order by its ID.
	 *
	 * @param id the ID of the order
	 * @return an Optional containing the found order, if any
	 */
	public Optional<Orders> findOrder(String id) {
		return orderRepository.findById(id);
	}

	/**
	 * Updates an existing order in the database.
	 *
	 * @param orders the order to update
	 * @return the updated order
	 */
	public Orders updateOrder(Orders orders) {
		return orderRepository.save(orders);
	}
	
	/**
	 * Deletes an order from the database.
	 *
	 * @param orders the order to delete
	 * @return true if deletion was successful
	 */
	public boolean deleteUser(Orders orders) {
		orderRepository.delete(orders);
		return true;
	}
}
