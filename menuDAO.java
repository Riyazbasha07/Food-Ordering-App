package com.foodApp.dao;


import java.util.ArrayList;

import com.foodApp.model.Menu;

public interface menuDAO {



	

	
		ArrayList<Menu>getAllMenus();
		ArrayList<Menu> getMenuByRestaurentId(int restaurentId);
		Menu getMenuById(int menuId);
		void addMenu(Menu or);
		void updateMenu(Menu or);
		void deleteMenu(int MenuId); 

}
