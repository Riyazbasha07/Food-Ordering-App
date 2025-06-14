package com.foodApp.dao;

import java.util.List;

import com.foodApp.model.User;

public interface userDAO {
	List<User>getAllUsers();
	User getUserById(int userId);
	int addUser(User u);
	void updateUser(User u);
	void deleteUser(int userid);
	User validateUser(String email, String password);

}
