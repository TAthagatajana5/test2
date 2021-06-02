package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

public class MenuItemService {

	private MenuItemDao menuItemDao;
	
	
	public void setMenuItemDao(MenuItemDao menuItemDao){
		this.menuItemDao = menuItemDao;
	}
	public List<MenuItem> getMenuItemListAdmin(){
		
	}
	public List<MenuItem> getMenuItemListCustomer(){
		
	}
	public MenuItem getMenuItem(long menuItemId) {
		
	}
	public void editMenuItem(MenuItem menutItem) {
		
	}
}
