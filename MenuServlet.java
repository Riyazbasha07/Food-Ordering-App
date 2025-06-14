package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.foodApp.daoimpl.MenuDAOImple;
import com.foodApp.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/menu")
public class MenuServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//int restaurentId = Integer.parseInt(req.getParameter("restaurentidParam"));		
             int restaurentId = Integer.parseInt(req.getParameter("restaurentId"));	
             HttpSession session = req.getSession();
             session.setAttribute("restaurentId", restaurentId);
             
           MenuDAOImple menuDAOImple = new  MenuDAOImple();
          ArrayList<Menu> allMenuByRestaurent = menuDAOImple.getMenuByRestaurentId(restaurentId);
          for(Menu x:allMenuByRestaurent) {
        	  System.out.println(x);
          }
          req.setAttribute("allMenuByRestaurent", allMenuByRestaurent);
          RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
          rd.forward(req, res);
           
	}

}
