package com.foodApp.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodApp.model.Restaurent;
import com.foodApp.model.User;

public interface restaurentDAO {
	List<Restaurent> getAllRestaurents();

	Restaurent getRestaurentById(int restaurentId);
	void addRestaurent(Restaurent r);
	void UpdateRestaurent(Restaurent r);
	void deleteRestaurent(int restaurentId); 
	List<Restaurent>searchRestaurents(String keyword);
	

}
