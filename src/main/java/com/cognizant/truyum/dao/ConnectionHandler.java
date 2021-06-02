package com.cognizant.truyum.dao;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection()
	{
		Connection con = null;
	    try
	    {
	    	Properties prop = new Properties();
	    	prop.load(new FileReader("C:\\Users\\TAthagata Jana\\Desktop\\training\\truYam\\src\\connection.properties"));
	    	
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/truyum",prop);
	    	if(con!=null) 
	    	{
	    		System.out.println("connected to database");
	    		
	    	}
	    	
	    }
	    catch (SQLException e) 
	    {
		
	    	System.out.println("Not connected to the database");
			e.printStackTrace();
		} catch (IOException e) 
	    {
			System.out.println("Connection Properties file not found");
			e.printStackTrace();
		}
	    return con;
	}

}
