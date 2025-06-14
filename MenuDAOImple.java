package com.foodApp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.app.util.DBConnection;
import com.foodApp.dao.menuDAO;
import com.foodApp.model.Menu;
import com.foodApp.model.User;

public class MenuDAOImple implements menuDAO{
	public static String GET_ALL_MENUS="select * from `menu`";
	public static String GET_MENU_BY_ID="select * from `menu` where menuId=?";
   public static String INSERT_MENU_QUERY="insert into `menu`(`menuId`,`restaurentId`,`itemName`,`description`,`price`,`isAvailable`,`ratings`,`imagePath`) "
   		+ "values("
   		+ "?,?,?,?,?,?,?,?)";
   public static String  GET_MENU_BY_RESTAURENTID="select * from menu where restaurentId=?";
     public static String EXECUTE_UPDATE="update `menu` set itemName=?, isAvailable=? where menuId=?";
     public static String DELETE_MENU_QUERY="delete  from `menu` where menuId=?";
	@Override
	public ArrayList<Menu> getAllMenus() {
		 ArrayList<Menu> list = new ArrayList<Menu>();
			try(Connection connection = DBConnection.getConnection();
					PreparedStatement	preparedStatement = connection.prepareStatement(GET_ALL_MENUS);) {
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
				Menu menu = extractMenu(resultSet);
				
			
			
	 	          list.add(menu);
				}
				 
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			return list;
		}
	public Menu extractMenu(ResultSet resultSet) {
		Menu menu=null;
		try {
				
				
					int menuId=resultSet.getInt("MenuId");
				 	   int restaurentId = resultSet.getInt("restaurentId");
				 	   String itemName = resultSet.getString("itemName");
				 	   String description = resultSet.getString("description");
				 	   double price = resultSet.getDouble("price");
				 	   String isAvailable = resultSet.getString("isAvailable");
				 	   String ratings = resultSet.getString("ratings");
				 	   String imagePath = resultSet.getString("imagePath");
				 	    menu = new Menu(menuId, restaurentId, itemName, description, price, isAvailable, price, imagePath);
					
			
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}
	public ArrayList<Menu> getMenuByRestaurentId(int restaurentId){
		Menu menu=null;
		 ArrayList<Menu> list = new ArrayList<Menu>();
		 try(Connection connection = DBConnection.getConnection();
					PreparedStatement	preparedStatement = connection.prepareStatement(GET_MENU_BY_RESTAURENTID);) {
				preparedStatement.setInt(1,restaurentId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
				 menu = extractMenu(resultSet);
				 list.add(menu);
				
			
			
	 	          
				 
			}
		 }
			 catch (SQLException e) {
					e.printStackTrace();
				}
		 return list;
		 
	}

	@Override
	public Menu getMenuById(int menuId) {
		Menu menu=null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(GET_MENU_BY_ID);) {
			preparedStatement.setInt(1,menuId);
			ResultSet resultSet = preparedStatement.executeQuery();
			 menu = extractMenu(resultSet);
			
		
		
 	          
			 
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
		return menu;
		
	}

	@Override
	public void addMenu(Menu m) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(INSERT_MENU_QUERY);
					) {
				
					
					preparedStatement.setInt(1, m.getMenuId());
					//sc.nextInt();
					preparedStatement.setInt(2,  m.getRestaurantId());
					preparedStatement.setString(3, m.getItemName());
					preparedStatement.setString(4, m.getDescription());
					preparedStatement.setDouble(5, m.getPrice());
					preparedStatement.setString(6, m.IsAvailable());
					preparedStatement.setDouble(7, m.getRatings());				
					preparedStatement.setString(8,m.getImagePath());
					
					
					int i = preparedStatement.executeUpdate();
					System.out.println(i);
					
			}
				 catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public void updateMenu(Menu m) {
		try( Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(EXECUTE_UPDATE)){

			preparedStatement.setInt(1, m.getMenuId());
			//preparedStatement.setString(2, u.getUserName());
		//	preparedStatement.setString(4, u.getEmail());
			preparedStatement.setString(3, m.getItemName());
			preparedStatement.setString(4, m.IsAvailable());
		//	preparedStatement.setString(4, m.getDescription());
			preparedStatement.setDouble(5, m.getPrice());
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void deleteMenu(int menuId) {
		   try {
			   Connection connection = DBConnection.getConnection();
			   PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MENU_QUERY);
			preparedStatement.setInt(1,menuId);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
		
	}
	
	


