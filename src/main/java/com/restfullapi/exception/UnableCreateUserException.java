package com.restfullapi.exception;

public class UnableCreateUserException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to create the user Check the parameters" ;
	}

}
