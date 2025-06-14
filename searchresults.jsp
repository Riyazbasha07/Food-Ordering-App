<%@ page import="java.util.*, com.foodApp.model.Restaurent"%>
<%
    List<Restaurent> restaurants = (List<Restaurent>) request.getAttribute("restaurants");
%>
<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background: linear-gradient(to right, #fceabb, #f8b500);
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	color: #333;
	margin-top: 30px;
	font-size: 2em;
}

.restaurant-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 20px;
	padding: 30px;
}

.restaurant-card {
	background-color: white;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	width: 280px;
	padding: 20px;
	text-align: center;
	transition: transform 0.3s ease;
}

.restaurant-card:hover {
	transform: translateY(-5px);
}

.restaurant-card img {
	width: 100%;
	height: 160px;
	object-fit: cover;
	border-radius: 8px;
}

.restaurant-card h3 {
	color: #ff5733;
	margin: 15px 0 10px;
	font-size: 1.4em;
}

.restaurant-card p {
	color: #555;
	font-size: 0.95em;
	line-height: 1.4;
}

.no-result {
	text-align: center;
	font-size: 1.2em;
	color: #fff;
	background: rgba(0, 0, 0, 0.5);
	padding: 20px;
	margin: 40px;
	border-radius: 12px;
}
</style>
</head>

<body>
	<h2>Search Results</h2>
	<div class="restaurant-container">
		<% if (restaurants != null && !restaurants.isEmpty()) {
            for (Restaurent r : restaurants) { %>
		<div class="restaurant-card">
			<img src="<%=request.getContextPath() %>/images/<%=r.getImageUrl()%>"
				alt="Image" height="100px">
			<h3><%=r.getName()%></h3>
			<p><%=r.getDescription()%></p>
		</div>
		<%  }
        } else { %>
		<p class="no-result">No restaurants found matching your search.</p>
		<% } %>
	</div>
</body>
</html>