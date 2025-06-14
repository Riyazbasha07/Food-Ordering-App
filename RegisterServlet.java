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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Read form fields
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        // Step 2: Populate User model
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);

        // Step 3: DAO logic
        UserDAOImple userDAO = new UserDAOImple();

        try {
            if (userDAO.isEmailExists(email)) {
                request.setAttribute("error", "Email already registered.");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            } else {
                int result = userDAO.addUser(user);
                if (result > 0) {
                    response.sendRedirect("login.jsp");
                } else {
                    request.setAttribute("error", "Registration failed. Please try again.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Something went wrong. Try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}