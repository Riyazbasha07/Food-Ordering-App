package com.foodApp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.util.DBConnection;
import com.foodApp.dao.userDAO;
import com.foodApp.model.User;

public class UserDAOImple implements userDAO {

	private final static  String INSERT_USER_QUERY="insert into users(`name`,`userName`,`password`,`email`,`phoneNumber`,`address`,`role`,`created_date`,`last_login_date`)"
			+"values(?,?,?,?,?,?,?,?,?) ";
	
	private final static String DELETE_USER_QUERY = "DELETE FROM `users` WHERE `userid`=?";	
	private final static   String update="update user set `name`=?,`password`=?,`phoneNumber`=?,`address`=?,`role`=?";//

	private final static  String GET_USER="Select * from user where userid=?";
	Scanner scan=new Scanner(System.in);
	private String GET_ALL_USERS="select * from user";
	

	@Override
	public List<User> getAllUsers() {
		 //User u=null;
		 ArrayList<User> list = new ArrayList<User>();
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(GET_ALL_USERS);) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			User u = extractUser(resultSet);
			
		
		
 	          list.add(u);
			}
			 
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public static User extractUser(ResultSet resultSet) throws SQLException{
		
		
		User u=null;
	
				//int id=resultSet.getInt("userId");
			 	   String name = resultSet.getString("name");
			 	   String userName = resultSet.getString("userName");
			 	   String password = resultSet.getString("password");
			 	   String email = resultSet.getString("email");
			 	   String phoneNumber = resultSet.getString("phoneNumber");
			 	   String address = resultSet.getString("address");
			 	   String role = resultSet.getString("role");
			 	   Timestamp created = resultSet.getTimestamp("created_date");
			 	   Timestamp lastlogin = resultSet.getTimestamp("last_login_date");
			 	  u = new User( userName, password, email, phoneNumber, address, role,created,lastlogin);
				
		
		return u;
		
		
	}
	public boolean isEmailExists(String email) {
		boolean exists=false;
		String query="SELECT 1 from users where email=?";
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				exists=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
		
	}
	@Override
	public User getUserById(int userId) {
		 User user=null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(GET_USER);) {
			
			preparedStatement.setInt(1,userId);
			
			
			 ResultSet resultSet = preparedStatement.executeQuery();
		
			  user = extractUser(resultSet);
			
					
					
				
					
				
					
			}
				 catch (SQLException e) {
					e.printStackTrace();
				}
		return user;
			
		}
		
	

	@Override
	public int  addUser(User u) {
		int i=0;
		if(!isEmailExists(u.getEmail())) {
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement	preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
				) {
			
				
				preparedStatement.setString(1, u.getName());
				preparedStatement.setString(2, u.getUserName());
				preparedStatement.setString(3, u.getPassword());
				preparedStatement.setString(4, u.getEmail());
				preparedStatement.setString(5, u.getPhoneNumber());
				preparedStatement.setString(6, u.getAddress());
				preparedStatement.setString(7, u.getRole());
				preparedStatement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
				preparedStatement.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
		
				
				
				 i = preparedStatement.executeUpdate();
				System.out.println(i);
		
				
		}
			 catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
		
	}

		
	

	@Override
	public void updateUser(User u) {
		//Connection connection=null;
		try( Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(update)){

			preparedStatement.setString(1, u.getName());
			//preparedStatement.setString(2, u.getUserName());
			preparedStatement.setString(2, u.getPassword());
		//	preparedStatement.setString(4, u.getEmail());
			preparedStatement.setString(3, u.getPhoneNumber());
			preparedStatement.setString(4, u.getAddress());
			preparedStatement.setString(5, u.getRole());
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
				
				

				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void deleteUser(int userId) {
   try {
	   Connection connection = DBConnection.getConnection();
	   PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
	preparedStatement.setInt(1,userId);
	int i = preparedStatement.executeUpdate();
	System.out.println(i);
	
} catch (SQLException e) {
	e.printStackTrace();
}
	}
	@Override
	
		public User validateUser(String email, String password) {
		    User user = null;
		    try (Connection conn = DBConnection.getConnection()) {
		        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		        PreparedStatement stmt = conn.prepareStatement(query);
		        stmt.setString(1, email);
		        stmt.setString(2, password);

		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) {
		        	
		            user = new User();
		            user.setUserId(rs.getInt("userid"));
		            user.setName(rs.getString("userName"));
		            user.setEmail(email);
		            user.setPassword(password);
		            
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    System.out.println(user.toString());
		    return user;
		}
	
	

}
