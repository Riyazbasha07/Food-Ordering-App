package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static final String  url="jdbc:mysql://localhost:3306/foodApp";
	private static final String userName="root";
	private static final String password="2003";
	public static Connection connection;

	public  static Connection getConnection() {
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
			
			 connection = DriverManager.getConnection(url,userName,password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			
			
			return connection;
      
	}
}


