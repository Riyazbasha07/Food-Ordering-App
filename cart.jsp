<%@ page
	import="java.util.Map, com.foodApp.model.CartItem, com.foodApp.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    int restaurentId = (session.getAttribute("restaurentId") != null) ? (Integer) session.getAttribute("restaurentId") : -1;
    Map<Integer, CartItem> items = (cart != null) ? cart.getItems() : null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poppins', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.navbar {
	background-color: #fff;
	padding: 15px 30px;
	display: flex;
	justify-content: space-between;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.navbar .logo {
	font-size: 1.8em;
	font-weight: 700;
	color: #e23744;
	text-decoration: none;
}

.container {
	max-width: 1000px;
	margin: 40px auto;
	background: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #e23744;
	text-align: center;
	margin-bottom: 30px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table th, table td {
	padding: 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

table th {
	background-color: #f8f8f8;
	color: #555;
}

.btn {
	padding: 10px 20px;
	border: none;
	background-color: #e23744;
	color: white;
	font-weight: 600;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
}

.btn:hover {
	background-color: #c82333;
}

.total {
	text-align: right;
	margin-top: 20px;
	font-size: 1.2em;
	font-weight: bold;
}

.actions form {
	display: inline;
}

input[type="number"] {
	padding: 6px;
	width: 60px;
	margin-right: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.button-group {
	text-align: center;
	margin-top: 30px;
}
</style>
</head>
<body>

	<div class="navbar">
		<a href="#" class="logo">FoodieFinds</a>
	</div>

	<div class="container">
		<h1>Your Cart</h1>
		<% if (items == null || items.isEmpty()) { %>
		<p style="text-align: center;">Your cart is empty.</p>
		<% } else { %>
		<table>
			<tr>
				<th>Item</th>
				<th>Qty</th>
				<th>Price</th>
				<th>Total</th>
				<th>Action</th>
			</tr>
			<%
                double grandTotal = 0;
                for (CartItem item : items.values()) {
                    double total = item.getQuantity() * item.getPrice();
                    grandTotal += total;
            %>
			<tr>
				<td><%= item.getName() %></td>
				<td>
					<form action="cart" method="post" style="display: inline;">
						<input type="number" name="quantity"
							value="<%= item.getQuantity() %>" min="1"> <input
							type="hidden" name="action" value="update"> <input
							type="hidden" name="itemId" value="<%= item.getItemId() %>">
						<input type="submit" value="Update" class="btn">
					</form>
				</td>
				<td>₹<%= item.getPrice() %></td>
				<td>₹<%= total %></td>
				<td class="actions">
					<form action="cart" method="post" style="display: inline;">
						<input type="hidden" name="action" value="delete"> <input
							type="hidden" name="itemId" value="<%= item.getItemId() %>">
						<input type="submit" value="Remove" class="btn">
					</form>
				</td>
			</tr>
			<% } %>
		</table>
		<div class="total">
			Grand Total: ₹<%= grandTotal %></div>
		<div class="button-group">
			<a href="menu?restaurentId=<%= restaurentId %>" class="btn">Continue
				Shopping</a> &nbsp;&nbsp;
			<form action="CheckOutServlet" method="post" style="display: inline;">
				<input type="submit" value="Proceed to Checkout" class="btn">
			</form>
		</div>
		<% } %>
	</div>

</body>
</html>
