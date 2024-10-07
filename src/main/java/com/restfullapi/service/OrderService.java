package com.restfullapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dao.OrderDao;
import com.restfullapi.dao.ProductDao;
import com.restfullapi.dao.UserDao;
import com.restfullapi.entity.Orders;
import com.restfullapi.entity.Product;
import com.restfullapi.entity.Users;
import com.restfullapi.exception.OrderNotFoundException;
import com.restfullapi.exception.UserNotFoundException;
import com.restfullapi.responseStructure.ResponseStructure;


@Service
public class OrderService {

	private OrderDao dao;
	private ProductDao productDao;
	private UserDao userDao;

	@Autowired
	public OrderService(OrderDao dao, UserDao userDao, ProductDao productDao) {
		this.dao = dao;
		this.userDao = userDao;
		this.productDao = productDao;
	}

	/**
	 * Saves a new order and products if they don't exist.
	 *
	 * @param orders the order to save
	 * @return response entity containing the saved order
	 */
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders orders) {
		for (Product product : orders.getProductList()) {
			if (product.getProduct_id() == null) {
				productDao.saveProduct(product);
			}
		}
		orders = dao.saveOrder(orders);
		ResponseStructure<Orders> response = new ResponseStructure<Orders>(HttpStatus.CREATED.value(),
				"Order saved successfully.", orders);
		return new ResponseEntity<ResponseStructure<Orders>>(response, HttpStatus.CREATED);
	}

	/**
	 * Retrieves an order by its ID.
	 *
	 * @param id the ID of the order to find
	 * @return response entity containing the found order
	 */
	public ResponseEntity<ResponseStructure<Orders>> findOrder(String id) {
		Orders order = dao.findOrder(id).orElseThrow(() -> new OrderNotFoundException());
		ResponseStructure<Orders> response = new ResponseStructure<Orders>(HttpStatus.FOUND.value(),
				"Order found successfully.", order);
		return new ResponseEntity<ResponseStructure<Orders>>(response, HttpStatus.FOUND);
	}

	/**
	 * Updates an existing order by its ID.
	 *
	 * @param orders the updated order details
	 * @param id the ID of the order to update
	 * @return response entity with the updated order
	 */
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders orders, String id) {
		dao.findOrder(id).orElseThrow(() -> new OrderNotFoundException());
		dao.saveOrder(orders);
		ResponseStructure<Orders> response = new ResponseStructure<Orders>(HttpStatus.OK.value(),
				"Order updated successfully.", orders);
		return new ResponseEntity<ResponseStructure<Orders>>(response, HttpStatus.OK);
	}

	/**
	 * Deletes an order by its ID.
	 *
	 * @param orders the order to delete
	 * @param id the ID of the order to delete
	 * @return response entity indicating the deletion status
	 */
	public ResponseEntity<ResponseStructure<Boolean>> deleteOrder(Orders orders, String id) {
		orders = dao.findOrder(id).orElseThrow(() -> new OrderNotFoundException());
		dao.deleteUser(orders);
		ResponseStructure<Boolean> response = new ResponseStructure<Boolean>(HttpStatus.OK.value(),
				"Order deleted successfully.", true);
		return new ResponseEntity<ResponseStructure<Boolean>>(response, HttpStatus.OK);
	}

	/**
	 * Retrieves all orders associated with a user.
	 *
	 * @param userId the ID of the user
	 * @return response entity containing the user's orders
	 */
	public ResponseEntity<ResponseStructure<List<Orders>>> getUsersOrder(String userId) {
		Optional<Users> user = Optional.ofNullable(userDao.findUser(userId)
				.orElseThrow(() -> new UserNotFoundException()));
		return new ResponseEntity<ResponseStructure<List<Orders>>>(
				new ResponseStructure<List<Orders>>(HttpStatus.FOUND.value(), "User orders found.", user.get().getOrdersList()),
				HttpStatus.FOUND);
	}

}
