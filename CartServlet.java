package com.tap.servlet;

import java.io.IOException;

import com.foodApp.model.Cart;
import com.foodApp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    // Define constants for actions to prevent typos
    private static final String ACTION_ADD = "add";
    private static final String ACTION_UPDATE = "update";
    private static final String ACTION_DELETE = "delete";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart"); // Retrieve cart from session

        // Get old restaurant ID from session
        Integer oldRestaurantId = (Integer) session.getAttribute("restaurantId");
        int oldRestaurantIdObj = (oldRestaurantId != null) ? oldRestaurantId : -1;

        // Get new restaurant ID from request parameter
        String newRestaurantIdParam = req.getParameter("restaurentId");
        int newRestaurantId = -1; // Default value if parameter is missing or invalid

        if (newRestaurantIdParam != null && !newRestaurantIdParam.isEmpty()) {
            try {
                newRestaurantId = Integer.parseInt(newRestaurantIdParam);
            } catch (NumberFormatException e) {
                System.err.println("Invalid restaurant ID format: " + newRestaurantIdParam);
                res.sendRedirect("error.jsp?message=Invalid restaurant ID provided.");
                return; // Stop processing if restaurant ID is invalid
            }
        }

        // Initialize a new cart or clear existing one if restaurant ID changes or cart is null
        if (cart == null || (newRestaurantId != -1 && oldRestaurantIdObj != newRestaurantId)) {
            cart = new Cart(); // Create a new cart
            session.setAttribute("cart", cart); // Store it in the session
            session.setAttribute("restaurantId", newRestaurantId); // Update restaurant ID in session

            // Optional: Inform the user if the cart was cleared due to a restaurant change
            if (oldRestaurantIdObj != -1 && oldRestaurantIdObj != newRestaurantId) {
                session.setAttribute("cartMessage", "Your previous cart was cleared because you selected items from a new restaurant.");
            }
        }

        String action = req.getParameter("action");

        // Basic validation for the 'action' parameter
        if (action == null || action.isEmpty()) {
            System.err.println("Action parameter is missing.");
            res.sendRedirect("error.jsp?message=Cart action not specified.");
            return;
        }

        // Process actions based on the 'action' parameter
        switch (action) {
            case ACTION_ADD:
                addItemToCart(req, cart);
                break;
            case ACTION_UPDATE:
                updateCart(req, cart);
                break;
            case ACTION_DELETE:
                deleteCart(req, cart);
                break;
            default:
                System.err.println("Unknown cart action: " + action);
                res.sendRedirect("error.jsp?message=Unknown cart action specified.");
                break;
        }

        res.sendRedirect("cart.jsp"); // Redirect to the cart display page after processing
    }

    private void deleteCart(HttpServletRequest req, Cart cart) {
        String itemIdParam = req.getParameter("itemId");
        if (itemIdParam != null && !itemIdParam.isEmpty()) {
            try {
                int itemId = Integer.parseInt(itemIdParam);
                cart.removeItem(itemId);
            } catch (NumberFormatException e) {
                System.err.println("Invalid item ID format for delete: " + itemIdParam);
                // Consider adding a session attribute for an error message to display on cart.jsp
            }
        } else {
            System.err.println("Item ID missing for delete action.");
        }
    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        String itemIdParam = req.getParameter("itemId");
        String quantityParam = req.getParameter("quantity");

        if (itemIdParam != null && !itemIdParam.isEmpty() && quantityParam != null && !quantityParam.isEmpty()) {
            try {
                int itemId = Integer.parseInt(itemIdParam);
                int quantity = Integer.parseInt(quantityParam);

                if (quantity > 0) {
                    cart.updateItem(itemId, quantity);
                } else if (quantity == 0) {
                    // If quantity is 0, it generally means the item should be removed
                    cart.removeItem(itemId);
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid item ID or quantity format for update: " + itemIdParam + ", " + quantityParam);
            }
        } else {
            System.err.println("Item ID or quantity missing for update action.");
        }
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {
        String itemIdParam = req.getParameter("itemId");
        String itemName = req.getParameter("itemName");
        String quantityParam = req.getParameter("quantity");
        String priceParam = req.getParameter("price");

        // Validate all necessary parameters are present and not empty
        if (itemIdParam != null && !itemIdParam.isEmpty() &&
            itemName != null && !itemName.isEmpty() &&
            quantityParam != null && !quantityParam.isEmpty() &&
            priceParam != null && !priceParam.isEmpty()) {
            try {
                int itemId = Integer.parseInt(itemIdParam);
                int quantity = Integer.parseInt(quantityParam);
                double price = Double.parseDouble(priceParam);

                // Basic validation for quantity and price
                if (quantity > 0 && price >= 0) {
                    CartItem item = new CartItem(itemId, itemName, quantity, price);
                    cart.addItem(item);
                } else {
                    System.err.println("Invalid quantity (" + quantity + ") or price (" + price + ") for adding item.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format for adding item to cart. Check item ID, quantity, or price.");
            }
        } else {
            System.err.println("Missing parameters for add item to cart.");
        }
    }
}