package com.foodApp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.util.DBConnection;
import com.foodApp.dao.restaurentDAO;
import com.foodApp.model.Restaurent;
import com.foodApp.model.User;

public class RestaurentDAOImple implements restaurentDAO {
	String GET_ALL_RESTAURENTS="select * from `restaurent`";
	String RESTAURENT_BY_ID="select * from `restaurent` where `restaurentId`=?";
          String ADD_RESTAURENT="insert into restaurent(`restaurentId`,`name`,`address`,`phone`,`rating`,`isActive`,'imageUrl','description') values(?,?,?,?,?,?,?,?)";
          String UPDATE_RESTAURENT="update `restaurent` set `name`=?,`address`=?`,`phone`=?,`rating`=?,`isActive`=? where `restaurentId`=? ";
          String DELETE_RESTAURENT="delete from `restaurent` where `restaurentId`=? ";
	@Override
	public ArrayList<Restaurent> getAllRestaurents() {
		ArrayList<Restaurent> list = new ArrayList<>();
	
			Connection connection;
	
				try {
					connection = DBConnection.getConnection();
				
			
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RESTAURENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			Restaurent restaurent = extract(resultSet);
			list.add(restaurent);
			}
				} catch ( SQLException e) {
					e.printStackTrace();
				}
			
		
		
		return list;
	}
	public Restaurent extract(ResultSet resultSet) {
		
		 Restaurent restaurent=null;
		
		try {
			
				int restaurentId=resultSet.getInt("restaurentId");
			 	   String name = resultSet.getString("name");
			 	   String address = resultSet.getString("address");
			 	   String phone = resultSet.getString("phone");
			 	   double rating = resultSet.getDouble("rating");
			 	   String isActive = resultSet.getString("isActive");
			 	   String imageUrl = resultSet.getString("imageUrl");
			 	  String description = resultSet.getString("description");
			 	  
			 	  
  restaurent = new Restaurent(restaurentId, name, address, phone, rating, isActive,imageUrl,description);
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return restaurent;
	}

	@Override
	public Restaurent getRestaurentById(int restaurentId) {
		Restaurent restaurent=null; 
		
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(RESTAURENT_BY_ID);
			preparedStatement.setInt(1, restaurentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			 restaurent = extract(resultSet);
			   
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return restaurent;
	}

	@Override
	public void addRestaurent(Restaurent r) {
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_RESTAURENT);
			preparedStatement.setInt(1,r.getRestaurentId());
			
			preparedStatement.setString(2, r.getName());
			preparedStatement.setString(3, r.getAddress());
			preparedStatement.setString(4, r.getPhone());
			preparedStatement.setDouble(5, r.getRating());
			preparedStatement.setString(6, r.getIsActive());
			preparedStatement.setString(7,r.getImageUrl());
			preparedStatement.setString(8,r.getDescription());
			
			//preparedStatement.setInt(6,r.getRestaurentId());
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}



	
	@Override
	public void UpdateRestaurent(Restaurent r) {
		try( Connection connection = DBConnection.getConnection();
				PreparedStatement	preparedStatement = connection.prepareStatement(UPDATE_RESTAURENT)){

			preparedStatement.setString(1, r.getName());
			//preparedStatement.setString(2, u.getUserName());
			preparedStatement.setString(2, r.getAddress());
		//	preparedStatement.setString(4, u.getEmail());
			preparedStatement.setString(3, r.getPhone());
			preparedStatement.setDouble(4, r.getRating());
			preparedStatement.setString(5, r.getIsActive());
			preparedStatement.setInt(6, r.getRestaurentId());
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
				
				

				
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
		
	

	@Override
	public void deleteRestaurent(int restaurentId) {
		Connection connection = DBConnection.getConnection();
	  try {
		PreparedStatement	preparedStatement = connection.prepareStatement(DELETE_RESTAURENT);
		preparedStatement.setInt(1, restaurentId);
		int i = preparedStatement.executeUpdate();
		System.out.println(i);
	} catch (SQLException e) {
		e.printStackTrace();
	}

		
	}
	public List<Restaurent>searchRestaurents(String keyword){
		  List<Restaurent> list = new ArrayList<>();
		    try (Connection con = DBConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement(
		             "SELECT * FROM restaurent WHERE name LIKE ? OR description LIKE ?")) {

		        String wildcardKeyword = "%" + keyword + "%";
		        ps.setString(1, wildcardKeyword);
		        ps.setString(2, wildcardKeyword);

		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            Restaurent r = new Restaurent();
		            r.setRestaurentId(rs.getInt("restaurentId"));
		            r.setName(rs.getString("name"));
		            r.setDescription(rs.getString("description"));
		            r.setImageUrl(rs.getString("imageUrl"));
		            list.add(r);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return list;
		}
	
	
	

}
