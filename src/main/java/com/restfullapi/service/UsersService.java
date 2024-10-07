package com.restfullapi.service;

import com.restfullapi.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dto.UserDto;
import com.restfullapi.entity.Users;
import com.restfullapi.responseStructure.ResponseStructure;

@Service
public interface UsersService {
	
	public ResponseEntity<ResponseStructure<Users>> saveUser(Users users) ;
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(String id) ;
	
	public ResponseEntity<ResponseStructure<Users>> updateUser(Users users, String id)  ;
	
	public ResponseEntity<ResponseStructure<Boolean>> deleteUser(Users users, String id) ;

    String login(LoginDto loginDto);
}
