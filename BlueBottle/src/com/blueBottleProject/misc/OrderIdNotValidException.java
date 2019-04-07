package com.blueBottleProject.misc;

public class OrderIdNotValidException extends Exception{
	private static final long serialVersionUID = -523311630981220152L;
	
	public OrderIdNotValidException(String errorMsg) {
		super(errorMsg);
	}

}
