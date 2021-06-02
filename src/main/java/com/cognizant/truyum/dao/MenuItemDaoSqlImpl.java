package com.cognizant.truyum.dao;
import java.sql.Date;

import java.sql.*;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoSqlImpl.class);

	public ArrayList<MenuItem> getMenuItemListAdmin()
	{
	LOGGER.info("Start");
	    ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		final String QUERY = "select * from menu_item";
		Connection con = ConnectionHandler.getConnection();
		try 
		{ 
			PreparedStatement stmt = con.prepareStatement(QUERY);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("menu_id");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date date1 = rs.getDate("date_of_launch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1 = new MenuItem(id,name,category,price,act,free,date1);
				menuItemList.add(m1);
			}
		} 
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		LOGGER.info("End");
		return menuItemList ;
		
	}
	public ArrayList<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("Start");
		ArrayList<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		final String Query = "select * from menu_item where active='Yes' AND date_of_launch <= curdate()";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("menu_id");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date date1 = rs.getDate("date_of_launch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1 = new MenuItem(id,name,category,price,act,free,date1);
				menuItemListCust.add(m1);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		LOGGER.info("End");
		return menuItemListCust;
		
	}
	public MenuItem getMenuItem(long menuItemId)
	{
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		MenuItem m1 = null;
		final String query = "select * from menu_item"+"where id=?";
		try 
		{
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, menuItemId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("id");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date date1 = rs.getDate("date_of_launch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				m1 = new MenuItem(id,name,category,price,act,free,date1);
			}
			
			
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		LOGGER.info("End");
		return m1;
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		Connection con = ConnectionHandler.getConnection();
		long id = menuItem.getId();
		String name = menuItem.getName();
		float price = menuItem.getPrice();
		boolean active = menuItem.isActive();
		
		java.sql.Date d =new Date( menuItem.getDateOfLaunch().getTime());
		String category = menuItem.getCategory();
		boolean free = menuItem.isFreeDelivery();
		String act;
		if(active == true)
		{
			act = "Yes";
		}
		else
		{
			act = "No";
		}
		String fd;
		if(free == true)
		{
			fd = "Yes";
		}
		else
		{
			fd = "No";
		}
		final String query = "update menu_item" + "set name = ?,price = ?,active = ?,date_of_launch = ?,category = ?,free_delivery = ?"+"where id = ?";
		try 
		{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			stmt.setString(3, act);
			stmt.setDate(4, d);
			stmt.setString(5,category);
			stmt.setString(6, fd);
			stmt.setLong(7, id);
			stmt.executeUpdate();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	LOGGER.info("End");
	}


