package com.restfullapi.serviceImpl;


import com.restfullapi.dto.LoginDto;
import com.restfullapi.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.restfullapi.dao.UserDao;
import com.restfullapi.dto.UserDto;
import com.restfullapi.entity.Users;
import com.restfullapi.exception.UserNotFoundException;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public String login(LoginDto loginDto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateJwt(loginDto.getEmail());
        }else
            throw new UsernameNotFoundException("Failed to authenticate user.");
    }

    /**
     * Save a new user.
     *
     * @param users - User entity object to be saved.
     * @return ResponseEntity containing ResponseStructure with the saved user and HttpStatus.
     */
    public ResponseEntity<ResponseStructure<Users>> saveUser(Users users) {

    	users.setPassword(passwordEncoder.encode(users.getPassword()));

        // Save the user entity to the database
        users = dao.saveUser(users);

        // Prepare a response structure with the saved user and success message
        ResponseStructure<Users> response = new ResponseStructure<Users>(
                HttpStatus.CREATED.value(), "User saved successfully.", users
        );

        // Return the response entity with HttpStatus.CREATED (201)
        return new ResponseEntity<ResponseStructure<Users>>(response, HttpStatus.CREATED);
    }

    /**
     * Find a user by ID.
     *
     * @param id - ID of the user to be retrieved.
     * @return ResponseEntity containing ResponseStructure with the found user or UserNotFoundException.
     */
    public ResponseEntity<ResponseStructure<UserDto>> findUser(String id) {

        // Find the user by ID or throw a UserNotFoundException if not found
        Users user = dao.findUser(id)
                .orElseThrow(() -> new UserNotFoundException());

        ResponseStructure<UserDto> response = new ResponseStructure<UserDto>(
                HttpStatus.FOUND.value(), "User found successfully.", new UserDto(user.getUser_id(), user.getUserName(), user.getPassword(), user.getEmail())
        );

        // Return the response entity with HttpStatus.FOUND (302)
        return new ResponseEntity<ResponseStructure<UserDto>>(response, HttpStatus.FOUND);
    }

    /**
     * Update an existing user.
     *
     * @param users - Updated user entity object.
     * @param id    - ID of the user to be updated.
     * @return ResponseEntity containing ResponseStructure with the updated user and HttpStatus.
     */
    public ResponseEntity<ResponseStructure<Users>> updateUser(Users users, String id) {

        Users upuser = dao.findUser(id)
                .orElseThrow(() -> new UserNotFoundException());

        // Save the updated user entity to the database
        dao.saveUser(users);

        ResponseStructure<Users> response = new ResponseStructure<Users>(
                HttpStatus.OK.value(), "Updated successfully.", users
        );

        return new ResponseEntity<ResponseStructure<Users>>(response, HttpStatus.OK);
    }

    /**
     * Delete a user by ID.
     *
     * @param users - User entity object to be deleted.
     * @param id    - ID of the user to be deleted.
     * @return ResponseEntity containing ResponseStructure with a boolean indicating deletion status.
     */
    public ResponseEntity<ResponseStructure<Boolean>> deleteUser(Users users, String id) {

        users = dao.findUser(id)
                .orElseThrow(() -> new UserNotFoundException());

        // Delete the user entity from the database
        dao.deleteUser(users);

        ResponseStructure<Boolean> response = new ResponseStructure<Boolean>(
                HttpStatus.OK.value(), "Deleted successfully.", true
        );

        return new ResponseEntity<ResponseStructure<Boolean>>(response, HttpStatus.OK);
    }

}
