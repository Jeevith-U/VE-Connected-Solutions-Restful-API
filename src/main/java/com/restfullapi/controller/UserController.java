package com.restfullapi.controller;


import com.restfullapi.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfullapi.dto.UserDto;
import com.restfullapi.entity.Users;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.UsersService;

@RestController  // Marks this class as a RESTful web service controller
public class UserController {

	private UsersService service;

    // Constructor-based dependency injection for UserService
    @Autowired
    public UserController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        return service.login(loginDto);
    }

    /**
     * Endpoint to save a new user.
     * @param users - User object that will be created.
     * @return ResponseEntity containing the ResponseStructure with the created user and HttpStatus.
     */
    @PostMapping("/register")  // Handles POST requests to save a new user
    public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users users) {
        return service.saveUser(users);  // Delegates the request to the service layer
    }

    /**
     * Endpoint to find a user by ID.
     * @param id - The ID of the user to be retrieved.
     * @return ResponseEntity containing the ResponseStructure with the found user or an error if not found.
     */
    @GetMapping("/users/{id}")  // Handles GET requests to find a user by their ID
    public ResponseEntity<ResponseStructure<UserDto>> findUser(@PathVariable String id) {
        return service.findUser(id);  // Delegates the request to the service layer to find the user
    }

    /**
     * Endpoint to update an existing user by ID.
     * @param users - Updated User object with new details.
     * @param id - The ID of the user to be updated.
     * @return ResponseEntity containing the ResponseStructure with the updated user and HttpStatus.
     */
    @PutMapping("/users/{id}")  // Handles PUT requests to update an existing user by their ID
    public ResponseEntity<ResponseStructure<Users>> updateUser(@RequestBody Users users, @PathVariable String id) {
        return service.updateUser(users, id);  // Delegates the update operation to the service layer
    }

    /**
     * Endpoint to delete a user by ID.
     * @param users - User object to be deleted (Optional in this case, could also only use ID).
     * @param id - The ID of the user to be deleted.
     * @return ResponseEntity containing the ResponseStructure indicating whether the deletion was successful.
     */
    @DeleteMapping("/users/{id}")  // Handles DELETE requests to delete a user by their ID
    public ResponseEntity<ResponseStructure<Boolean>> deleteOrder(@RequestBody Users users, @PathVariable String id) {
        return service.deleteUser(users, id);  // Delegates the delete operation to the service layer
    }
}
