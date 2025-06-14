package com.tap.servlet;
import java.io.IOException;
import java.util.List;

import com.foodApp.dao.restaurentDAO;
import com.foodApp.daoimpl.RestaurentDAOImple;
import com.foodApp.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private restaurentDAO restaurantDAO;

    public void init() {
        restaurantDAO = new RestaurentDAOImple();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");

        List<Restaurent> matchedRestaurants = restaurantDAO.searchRestaurents(query);
        request.setAttribute("restaurants", matchedRestaurants);
        request.getRequestDispatcher("searchresults.jsp").forward(request, response);
    }
}