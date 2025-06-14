package com.tap.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.foodApp.dao.orderDAO;
import com.foodApp.daoimpl.OrderDAOImple;
import com.foodApp.daoimpl.OrderItemDAOImpl;
import com.foodApp.model.Cart;
import com.foodApp.model.CartItem;
import com.foodApp.model.OrderItem;
import com.foodApp.model.Orders;
import com.foodApp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {

    private orderDAO orderDAO;

    @Override
    public void init() {
        this.orderDAO = new OrderDAOImple();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (cart == null || cart.getItems().isEmpty()) {
            request.setAttribute("message", "Your cart is empty.");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            return;
        }

        Integer restaurentId = (Integer) session.getAttribute("restaurentId");
        if (restaurentId == null) {
            request.setAttribute("message", "Restaurant not selected.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
            return;
        }

        String paymentMethod = request.getParameter("paymentMethod");
        String address = request.getParameter("address");

        Orders order = new Orders();
        order.setUserId(user.getUserId());
        order.setRestaurentId(restaurentId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setPaymentMethod(paymentMethod);
        order.setDeliveryAddress(address);
        order.setStatus("pending");

        double totalAmount = 0;
        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        order.setTotalPrice(totalAmount);

        int orderId = orderDAO.addOrder(order);
		OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

		for (CartItem item : cart.getItems().values()) {
		    OrderItem orderItem = new OrderItem(orderId, item.getItemId(), item.getQuantity(), item.getPrice());
		    orderItemDAO.addItem(orderItem);
		}

		// Clear cart after successful order
		session.removeAttribute("cart");
		
		
		request.setAttribute("orderId", orderId);
		request.setAttribute("totalAmount", totalAmount);
		request.setAttribute("message", "Order placed successfully!");
		request.getRequestDispatcher("orderSuccess.jsp").forward(request, response);
    }
}