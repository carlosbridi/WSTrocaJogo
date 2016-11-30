package com.data.generic;

public class ServiceException extends RuntimeException {

	public ServiceException(String msgException){
		throw new RuntimeException(msgException);
	}
	
}
