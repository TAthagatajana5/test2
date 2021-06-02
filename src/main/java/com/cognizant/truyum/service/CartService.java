package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;

public class CartService {

	CartDao cartDao;
	
	public List<MenuItem> getAllCartItems(long userId){
		//raises CartEmptyException
		
	}
	public void setCartDao(CartDao cartDao){
		
	}
	public void addCartItem(long userId,long menuItemId) {
		
	}
	public void removeCartItem(long userId,long  menuItemId) {
		
	}
}
