package com.restfullapi.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restfullapi.entity.Users;
import com.restfullapi.repository.UserRepository;

	
/**
 * DAO class for managing CRUD operations for Users.
 */
@Repository
public class UserDao {

	private UserRepository repo;

	@Autowired
	public UserDao(UserRepository repository) {
		this.repo = repository;
	}

	/**
	 * Saves a new user to the database.
	 *
	 * @param users the user to save
	 * @return the saved user
	 */
	public Users saveUser(Users users) {
		return repo.save(users);
	}
	
	/**
	 * Finds a user by their ID.
	 *
	 * @param id the ID of the user
	 * @return an Optional containing the found user, if any
	 */
	public Optional<Users> findUser(String id) {
		return repo.findById(id);
	}

	/**
	 * Updates an existing user in the database.
	 *
	 * @param users the user to update
	 * @return the updated user
	 */
	public Users UpdateUser(Users users) {
		return repo.save(users);
	}
	
	/**
	 * Deletes a user from the database.
	 *
	 * @param user the user to delete
	 * @return true if deletion was successful
	 */
	public boolean deleteUser(Users user) {
		repo.delete(user);
		return true;
	}
}
