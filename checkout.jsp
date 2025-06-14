<%@ page
	import="java.util.Map, com.foodApp.model.CartItem, com.foodApp.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Map<Integer, CartItem> items = (cart != null) ? cart.getItems() : null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poppins', sans-serif;
	background-color: #fff3e0;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 40px auto;
	background: #ffffff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
}

h1 {
	text-align: center;
	color: #ff6f00;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 25px;
}

table th, table td {
	text-align: center;
	padding: 12px;
	border-bottom: 1px solid #ddd;
}

table th {
	background-color: #ffe0b2;
}

.total {
	text-align: right;
	margin-top: 20px;
	font-size: 1.2em;
	font-weight: bold;
}

.form-group {
	margin: 20px 0;
}

.form-group textarea, .form-group select {
	width: 100%;
	padding: 10px;
	font-size: 15px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.btn {
	padding: 12px 25px;
	background-color: #ff6f00;
	color: white;
	border: none;
	border-radius: 6px;
	font-weight: 600;
	cursor: pointer;
	text-decoration: none;
	display: block;
	width: 100%;
	margin-top: 15px;
	font-size: 16px;
}

.btn:hover {
	background-color: #e65100;
}

.message {
	color: red;
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Checkout</h1>

		<% if (items == null || items.isEmpty()) { %>
		<p style="text-align: center;">
			Your cart is empty. <a href="home.jsp">Go to Home</a>
		</p>
		<% } else {
        double grandTotal = 0;
    %>

		<table>
			<tr>
				<th>Item</th>
				<th>Qty</th>
				<th>Price</th>
				<th>Total</th>
			</tr>
			<% for (CartItem item : items.values()) {
            double total = item.getQuantity() * item.getPrice();
            grandTotal += total;
        %>
			<tr>
				<td><%= item.getName() %></td>
				<td><%= item.getQuantity() %></td>
				<td>₹<%= item.getPrice() %></td>
				<td>₹<%= total %></td>
			</tr>
			<% } %>
		</table>

		<div class="total">
			Grand Total: ₹<%= grandTotal %></div>

		<form action="CheckOutServlet" method="post">
			<div class="form-group">
				<label for="address">Delivery Address:</label>
				<textarea name="address" rows="3" required></textarea>
			</div>

			<div class="form-group">
				<label for="paymentMethod">Payment Method:</label> <select
					name="paymentMethod" required>
					<option value="">-- Select Payment Method --</option>
					<option value="Cash on Delivery">Cash on Delivery</option>
					<option value="UPI">UPI</option>
					<option value="Card">Card</option>
				</select>
			</div>

			<input type="submit" class="btn" value="Place Order">
		</form>

		<% } %>
	</div>

</body>
</html>