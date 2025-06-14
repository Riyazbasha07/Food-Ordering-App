package com.foodApp.daoimpl;
import com.foodApp.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import  com.foodApp.model.Orders;
import com.foodApp.model.User;
import com.app.util.DBConnection;
import com.foodApp.dao.orderDAO;
import com.foodApp.model.Orders;

public class OrderDAOImple implements orderDAO {
	public static String GET_ALL_ORDERS="select * from `Orders`";
	public static String GET_ORDER="SELECT * from `orders` where `orderId`=?";
	public static String ADD_ORDER="insert into `orders`(orderId,userId,restaurentId,orderDate,paymentMethod,setDeliveryAddress,totalPrice,status) values(?,?,?,?,?,?,?,?)";
	public static String UPDATE_ORDERS="update `orders` set status=? where orderId=?";
	public static String DELETE_ORDER_BY_ID="DELETE from orders where `orderId=?`";

	@Override
	public List<Orders> getAllOrders() {
		ArrayList<Orders> list = new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			Orders or = extract(resultSet);
			list.add(or);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Orders extract(ResultSet resultSet) {
		Orders or=null;
		
		try {
			while(resultSet.next()) {
				int orderId=resultSet.getInt("orderId");
				int userId=resultSet.getInt("userId");
				int restaurentId=resultSet.getInt("restaurentId");
			 	   Timestamp orderDate = resultSet.getTimestamp("orderDate");
			 	   
			 	   String paymentMethod = resultSet.getString("paymentMethod");
			 	   String setDeliveryAddress = resultSet.getString("setDeliveryAddress");
			 	   String status = resultSet.getString("status");
			 	   Double totalPrice = resultSet.getDouble("totalPrice");
			 	 or = new Orders(orderId, userId, restaurentId, orderDate,paymentMethod,setDeliveryAddress, status,totalPrice);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return or;
	
		
	}

	@Override
	public Orders getOrderById(int OrderId) {
		 Orders or=null;
			try(Connection connection = DBConnection.getConnection();
					PreparedStatement	preparedStatement = connection.prepareStatement(GET_ORDER);) {
				
				preparedStatement.setInt(1,OrderId);
				
				
				 ResultSet resultSet = preparedStatement.executeQuery();
			
				  or = extract(resultSet);
				
						
						
					
						
					
						
				}
					 catch (SQLException e) {
						e.printStackTrace();
					}
			return or;
	}

	@Override
	public int addOrder(Orders or) {
               Connection connection = DBConnection.getConnection();	
               PreparedStatement preparedStatement=null;
               int generated_key=0;
               try {
            	   preparedStatement = connection.prepareStatement(ADD_ORDER,Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, or.getOrderId());
				preparedStatement.setInt(2, or.getUserId());
				preparedStatement.setInt(3, or.getRestaurentId());
				preparedStatement.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
				preparedStatement.setString(5,or.getPaymentMethod());
				preparedStatement.setString(6,or.getSetDeliveryAddress());
				preparedStatement.setString(7,or.getStatus());
				preparedStatement.setDouble(8, or.getTotalPrice());
				int affectedRows = preparedStatement.executeUpdate();
				System.out.println(affectedRows);
				if(affectedRows==0) {
					throw new SQLException("creating order failed,no rows affected");
				}
		
			if(affectedRows>0) {
               ResultSet rs = preparedStatement.getGeneratedKeys();
               if(rs.next()) {
            	   generated_key=rs.getInt(1);
               }
			}
               
              
	} catch (SQLException e) {
		e.printStackTrace();
	}
               System.out.println(generated_key);
               return generated_key;
	}

	@Override
	public void updateOrder(Orders or) {
		try( Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(UPDATE_ORDERS)){

			preparedStatement.setInt(2, or.getOrderId());
			//preparedStatement.setInt(2, or.getRestaurentId());
		//	preparedStatement.setInt(3, or.getUserId());
		//	preparedStatement.setDouble(4, or.getTotalPrice());
			preparedStatement.setString(1,or.getStatus());
			int i = preparedStatement.executeUpdate();
			
			
			
			System.out.println(i);		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void deleteOrder(int orderId) {
		 try {
			   Connection connection = DBConnection.getConnection();
			   PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID);
			preparedStatement.setInt(1,orderId);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
	}
	

	

}
