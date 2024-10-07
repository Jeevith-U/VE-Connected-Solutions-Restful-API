package com.restfullapi.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restfullapi.entity.Product;
import com.restfullapi.repository.ProductRepository;

@Repository
public class ProductDao {

	private ProductRepository productRepository;

	@Autowired
	public ProductDao(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Saves a new product to the database.
	 *
	 * @param product the product to save
	 * @return the saved product
	 */
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id the ID of the product
	 * @return an Optional containing the found product, if any
	 */
	public Optional<Product> findProduct(String id) {
		return productRepository.findById(id);
	}

	/**
	 * Updates an existing product in the database.
	 *
	 * @param product the product to update
	 * @return the updated product
	 */
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * Deletes a product from the database.
	 *
	 * @param product the product to delete
	 * @return true if deletion was successful
	 */
	public boolean deleteProduct(Product product) {
		productRepository.delete(product);
		return true;
	}
	
	/**
	 * Retrieves all products from the database.
	 *
	 * @return a list of all products
	 */
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
}
