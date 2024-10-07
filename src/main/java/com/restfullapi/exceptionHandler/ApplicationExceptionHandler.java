package com.restfullapi.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restfullapi.exception.OrderNotFoundException;
import com.restfullapi.exception.ProductNotFoundException;
import com.restfullapi.exception.UnableCreateOrderException;
import com.restfullapi.exception.UnableCreateProductException;
import com.restfullapi.exception.UnableCreateUserException;
import com.restfullapi.exception.UserNotFoundException;
import com.restfullapi.responseStructure.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(UnableCreateUserException.class)
	public ResponseEntity<ResponseStructure<String>> unableCreateUserException(
			UnableCreateUserException unableCreateUserException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + unableCreateUserException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnableCreateProductException.class)
	public ResponseEntity<ResponseStructure<String>> unableCreateProductException(
			UnableCreateProductException unableCreateProductException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + unableCreateProductException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnableCreateOrderException.class)
	public ResponseEntity<ResponseStructure<String>> unableCreateOrderException(
			UnableCreateOrderException unableCreateOrderException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + unableCreateOrderException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userNotFoundException(
			UserNotFoundException userNotFoundException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + userNotFoundException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productNotFoundException(
			ProductNotFoundException productNotFoundException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + productNotFoundException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> orderNotFoundException(
			OrderNotFoundException orderNotFoundException) {

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : " + orderNotFoundException.getMessage());
		response.setData("Please Check Credentials");
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.BAD_REQUEST);
	}
}
