package com.cognizant.truyum.dao;
@SuppressWarnings("serial")
public class CartEmptyException extends Exception{

	public CartEmptyException()
	{
		super();
		System.out.println("cart is empty");
	}
}
