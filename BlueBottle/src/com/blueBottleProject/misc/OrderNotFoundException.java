package com.blueBottleProject.misc;

public class OrderNotFoundException extends Exception{
	private static final long serialVersionUID = -505936309342057188L;

	public OrderNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
