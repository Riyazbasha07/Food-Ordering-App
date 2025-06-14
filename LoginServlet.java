package com.tap.servlet;

import java.io.IOException;

import com.foodApp.daoimpl.UserDAOImple;
import com.foodApp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAOImple userDAO = new UserDAOImple();
        User user = userDAO.validateUser(email, password); // Validate user credentials

        if (user != null) {
            HttpSession session = request.getSession();

            // Use lowercase key to match usage in other servlets
            session.setAttribute("user", user);

            // Optional: Store userId and userName if needed
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getName());

            System.out.println("User logged in: " + user);

            response.sendRedirect("HomeServlet"); // Go to home
        } else {
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }
}