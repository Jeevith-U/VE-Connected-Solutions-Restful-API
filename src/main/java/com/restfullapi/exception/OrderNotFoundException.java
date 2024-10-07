package com.restfullapi.exception;


public class OrderNotFoundException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to find the Order Check The Paramter.." ;
	}

}
