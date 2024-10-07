package com.restfullapi.exception;

public class UserNotFoundException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to find the User Check The Paramter.." ;
	}

}
