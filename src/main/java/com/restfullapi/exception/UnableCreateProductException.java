package com.restfullapi.exception;

public class UnableCreateProductException extends RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "Unable to create the Product Check the parameters" ;
	}

}
