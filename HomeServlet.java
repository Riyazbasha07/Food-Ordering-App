package com.tap.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.daoimpl.OrderItemDAOImpl;
import com.foodApp.daoimpl.RestaurentDAOImple;
import com.foodApp.daoimpl.UserDAOImple;
import com.foodApp.model.OrderItem;
import com.foodApp.model.Restaurent;
import com.foodApp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		RestaurentDAOImple restaurentDAOImple = new RestaurentDAOImple();
		ArrayList<Restaurent> allRestaurents = restaurentDAOImple.getAllRestaurents();
//		OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
//		ArrayList<OrderItem> allItems = orderItemDAOImpl.getAllItems();
//		UserDAOImple userDAOImple = new UserDAOImple();
//		List<User> allUsers = userDAOImple.getAllUsers();
		for(Restaurent x:allRestaurents) {
			System.out.println(x);
			
		}
		req.setAttribute("allRestaurents", allRestaurents);
		RequestDispatcher rd = req.getRequestDispatcher("Home1.jsp");
		rd.forward(req, res);
		
	}	
}
	

	

