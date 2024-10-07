package com.restfullapi.exception;

public class UnableCreateOrderException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to create the Orders Check the parameters" ;
	}

}
