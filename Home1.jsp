<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.model.Restaurent, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="styles.css" />
<style type="text/css">
}
</style>

</head>
<body>
	<nav class="navbar">
		<a href="#" class="logo">FoodieFinds</a>
		<div class="menu-toggle" id="mobile-menu">
			<span class="bar"></span> <span class="bar"></span> <span class="bar"></span>
		</div>
		<ul class="nav-links">

			<li><a href="login.jsp" class="auth-buttons">LOGIN</a></li>
			<li><a href="register.jsp" class="btn-auth">REGISTER</a></li>
		</ul>
	</nav>

	<header class="hero-section">
		<h1>Craving Something Delicious?</h1>
		<p>Discover the best restaurants and deals near you.</p>
		<div class="search-bar">
			<form action="SearchServlet" method="get"
				style="display: flex; flex-direction-row; width: 100%">
				<input type="text" name="query"
					placeholder="Search for restaurants or dishes...">
				<button class="search-bar input">Search</button>
			</form>
		</div>
	</header>

	<main class="main-content" align="center">
		<h2 class="h2">Popular Restaurants</h2>

		<div class="restaurant-grid">

			<%
      ArrayList<Restaurent> restaurent=( ArrayList<Restaurent>)request.getAttribute("allRestaurents");
      for(Restaurent restaurents: restaurent){
    	  %>

			<div class="restaurant-card">
				<div class="image-container">
					<img
						src="<%=request.getContextPath() %>/images/<%=restaurents.getImageUrl()  %>"
						alt="Restaurant 1">
				</div>
				<h3><%= restaurents.getName() %></h3>
				<p class="description"><%=restaurents.getDescription() %></p>
				<div class="details">
					<div class="rating"><%=restaurents.getRating() %></div>
					<a href="menu?restaurentId=<%=restaurents.getRestaurentId() %>">
						<div class="status active"><%=restaurents.getIsActive() %></div>
					</a>
				</div>

			</div>







			<%  }
      %>






		</div>

		</div>
	</main>






</body>