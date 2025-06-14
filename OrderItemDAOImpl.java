package com.foodApp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.app.util.DBConnection;
import com.foodApp.dao.orderItemDAO;
import com.foodApp.model.OrderItem;
import com.foodApp.model.User;

public class OrderItemDAOImpl implements orderItemDAO {
	public static String GET_ALL_ORDERITEMS="select * from OrderItem";
	public static String GET_ALL_ADDITEM="insert into orderitem(orderItemId,orderId,menuId,quantity,totalAmount) values(?,?,?,?,?)";
	public static String UPDATE_ITEM="update `orderItem` set quantity=?,totalAmount=? where orderItemId=?";
	public static String DELETE_ITEM="delete from OrderItem where orderItemId=?";
	public static String GET_ORDER_ITEM_BY_ID="SELECT * FROM orderItem where orderItemId=?";

	public ArrayList<OrderItem> getAllItems() {
		OrderItem item=null;
		 ArrayList<OrderItem> list = new ArrayList<OrderItem>();
			try(Connection connection = DBConnection.getConnection();
					PreparedStatement	preparedStatement = connection.prepareStatement(GET_ALL_ORDERITEMS);) {
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
				
				 item= extractOrderItem(resultSet);
				
			
			
	 	          list.add(item);
				}
				 
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			return list;
		}
	public static OrderItem extractOrderItem(ResultSet resultSet) {
		OrderItem item=null;
		try {
				
				
					int orderItemId=resultSet.getInt("orderItemId");
				 	   int orderId = resultSet.getInt("orderId");
				 	   int menuId = resultSet.getInt("menuId");
				 	   int quantity = resultSet.getInt("quantity");
				 	   int totalAmount = resultSet.getInt("totalAmount");
				 	    item = new OrderItem(orderItemId, orderId, menuId, quantity, totalAmount);
				 	   
				 	   
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
			
		}
		
		
	
	@Override
	public void addItem(OrderItem itemId) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(GET_ALL_ADDITEM);) {
			
			preparedStatement.setInt(1, itemId.getOrderItemId());
			preparedStatement.setInt(2, itemId.getOrderId());
			preparedStatement.setInt(3, itemId.getMenuId());
			preparedStatement.setInt(4, itemId.getQuantity());
			preparedStatement.setDouble(5, itemId.getTotalAmount());
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(OrderItem item) {
		try( Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(UPDATE_ITEM)){

			
			preparedStatement.setInt(1, item.getQuantity());
			preparedStatement.setDouble(2, item.getTotalAmount());
		preparedStatement.setInt(3, item.getOrderItemId());
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
				
				

				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
		
	

	@Override
	public void deleteItemById(int orderItemId) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement;
		
				preparedStatement = connection.prepareStatement(DELETE_ITEM);
			
			
			preparedStatement.setInt(1, orderItemId);
			int i = preparedStatement.executeUpdate();
	    		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		}



	@Override
	public OrderItem getOrderItemById(int itemId) {
		OrderItem orderItem=null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement;
		
				preparedStatement = connection.prepareStatement(GET_ORDER_ITEM_BY_ID);
				preparedStatement.setInt(1, itemId);
			  ResultSet resultSet = preparedStatement.executeQuery();
			   orderItem = extractOrderItem(resultSet);
			
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		return orderItem;
		
		
	}
	
	

}
