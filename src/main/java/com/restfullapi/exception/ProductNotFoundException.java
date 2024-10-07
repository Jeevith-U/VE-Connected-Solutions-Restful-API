package com.restfullapi.exception;

public class ProductNotFoundException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to find the Product Check The Paramter.." ;
	}

}
