<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import=" com.foodApp.model.Menu,java.util.ArrayList"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Spice Route - Main Courses Menu</title>

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&family=Playfair+Display:wght@700&display=swap"
	rel="stylesheet">

<style>

/* General Styles & Reset */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Poppins', sans-serif;
	background-color: black; # f8f8f8;
	color: #333;
	line-height: 1.6;
}

/* Navigation Bar */
.navbar {
	background-color: #fff;
	padding: 15px 30px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
	display: flex;
	justify-content: space-between;
	align-items: center;
	position: sticky;
	top: 0;
	z-index: 1000;
}

.navbar .logo {
	font-size: 1.8em;
	font-weight: 700;
	color: #e23744; /* Zomato/Swiggy red */
	text-decoration: none;
}

.navbar .nav-links {
	list-style: none;
	display: flex;
	gap: 25px;
}

.navbar .nav-links a {
	text-decoration: none;
	color: #555;
	font-weight: 500;
	transition: color 0.3s ease;
}

.navbar .nav-links a:hover {
	color: #e23744;
}

.navbar .menu-toggle {
	display: none;
	flex-direction: column;
	cursor: pointer;
}

.navbar .menu-toggle .bar {
	width: 25px;
	height: 3px;
	background-color: #333;
	margin: 4px 0;
	transition: 0.3s;
}

/* Restaurant Header / Banner */
.restaurant-header {
	background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url('https://source.unsplash.com/random/1600x400/?indian-restaurant-interior,curry')
		center center/cover no-repeat;
	color: #fff;
	text-align: center;
	padding: 80px 20px;
	margin-bottom: 40px;
	position: relative;
}

.restaurant-header::before {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background: rgba(0, 0, 0, 0.4); /* Dark overlay */
	z-index: 1;
}

.restaurant-header .content {
	position: relative;
	z-index: 2;
}

.restaurant-header h1 {
	font-family: 'Playfair Display', serif;
	font-size: 3.5em;
	margin-bottom: 15px;
	font-weight: 700;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.restaurant-header p {
	font-size: 1.2em;
	max-width: 800px;
	margin: 0 auto 20px;
}

.restaurant-header .info {
	display: flex;
	justify-content: center;
	gap: 25px;
	font-size: 1.1em;
	margin-top: 20px;
}

.restaurant-header .info span {
	background-color: rgba(255, 255, 255, 0.2);
	padding: 8px 15px;
	border-radius: 25px;
	backdrop-filter: blur(5px);
	display: flex;
	align-items: center;
	gap: 8px;
}

/* Menu Section */
.menu-container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

.menu-category {
	margin-bottom: 40px;
	padding: 20px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
}

.menu-category h2 {
	font-family: 'Playfair Display', serif;
	font-size: 2.5em;
	color: #e23744;
	text-align: center;
	margin-bottom: 30px;
	position: relative;
	padding-bottom: 10px;
}

.menu-category h2::after {
	content: '';
	position: absolute;
	bottom: 0;
	left: 50%;
	transform: translateX(-50%);
	width: 80px;
	height: 3px;
	background-color: #ff9800;
	border-radius: 2px;
}

/* Flexbox for Menu Grid */
.menu-grid {
	display: flex;
	flex-wrap: wrap; /* Allows items to wrap to the next line */
	gap: 30px; /* Space between menu item cards */
	justify-content: flex-start; /* Align items to the start of the row */
}

.menu-item-card {
	background-color: #fff;
	border: 1px solid #eee;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.06);
	display: flex;
	flex-direction: column;
	transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
	/* Flexbox sizing for 3 items per row */
	width: calc(( 100% - ( 2 * 30px))/3); /* (100% - 2 gaps) / 3 items */
	flex-shrink: 0;
	/* Prevent items from shrinking below calculated width */
	flex-grow: 1;
	/* Allow items to grow if space is available (e.g., less than 3 items) */
	min-width: 280px;
	/* Ensure minimum width for readability on smaller items */
}

.menu-item-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
}

.menu-item-card .item-image-container {
	width: 100%;
	height: 200px; /* Fixed height for images */
	overflow: hidden;
}

.menu-item-card img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	transition: transform 0.3s ease;
}

.menu-item-card:hover img {
	transform: scale(1.05);
}

.menu-item-card .item-details {
	padding: 15px;
	display: flex;
	flex-direction: column;
	flex-grow: 1;
}

.menu-item-card .item-name {
	font-size: 1.4em;
	font-weight: 600;
	margin-bottom: 8px;
	color: #e23744; /* Match brand color */
}

.menu-item-card .item-description {
	font-size: 0.95em;
	color: #555;
	margin-bottom: 10px;
	flex-grow: 1; /* Allow description to take available space */
}

.menu-item-card .item-price {
	font-size: 1.5em;
	font-weight: 700;
	color: #4CAF50; /* Green for price */
	text-align: right;
	margin-top: auto; /* Push price to the bottom */
}

.menu-item-card .price-description {
	font-size: 0.8em;
	color: #888;
	text-align: right;
	margin-top: 5px;
}

/* Footer */
.footer {
	background-color: #333;
	color: #eee;
	text-align: center;
	padding: 30px 20px;
	margin-top: 60px;
	font-size: 0.9em;
}

.footer .social-links a {
	color: #fff;
	margin: 0 10px;
	font-size: 1.5em;
	text-decoration: none;
	transition: color 0.3s ease;
}

.footer .social-links a:hover {
	color: #e23744;
}

/* Responsive Adjustments */
@media ( max-width : 992px) {
	.menu-item-card {
		/* Two items per row */
		width: calc(( 100% - 30px)/2); /* (100% - 1 gap) / 2 items */
	}
	.restaurant-header h1 {
		font-size: 2.8em;
	}
	.restaurant-header .info {
		flex-direction: column;
		gap: 10px;
	}
}

@media ( max-width : 768px) {
	.navbar {
		flex-wrap: wrap;
		justify-content: center;
		padding: 15px 20px;
	}
	.navbar .logo {
		width: 100%;
		text-align: center;
		margin-bottom: 15px;
	}
	.navbar .nav-links {
		display: none;
		flex-direction: column;
		width: 100%;
		text-align: center;
		background-color: #fff;
		box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
		border-radius: 8px;
		padding: 10px 0;
	}
	.navbar .nav-links.active {
		display: flex;
	}
	.navbar .nav-links li {
		margin: 10px 0;
	}
	.navbar .menu-toggle {
		display: flex;
		position: absolute;
		right: 20px;
		top: 20px;
	}
	.restaurant-header {
		padding: 60px 20px;
	}
	.restaurant-header h1 {
		font-size: 2.2em;
	}
	.restaurant-header p {
		font-size: 1em;
	}
	.menu-category h2 {
		font-size: 2em;
	}
	.menu-item-card {
		/* One item per row */
		width: 100%;
	}
}

@media ( max-width : 480px) {
	.navbar .logo {
		font-size: 1.5em;
	}
	.restaurant-header h1 {
		font-size: 1.8em;
	}
	.menu-category h2 {
		font-size: 1.8em;
	}
	.menu-item-card .item-name {
		font-size: 1.2em;
	}
	.menu-item-card .item-price {
		font-size: 1.3em;
	}
}

/* --- Add to Cart Button Styles --- */

/* Basic Button Styling */
.menu-item-card form input[type="submit"] {
	background-color: #e23744; /* Zomato/Swiggy red from your logo */
	color: #fff;
	border: none;
	padding: 10px 18px; /* Slightly adjusted padding for better look */
	border-radius: 5px; /* Slightly rounded corners */
	cursor: pointer;
	font-size: 1em;
	font-weight: 600;
	margin-top: 15px; /* Space from price/description */
	width: 100%; /* Make button full width of card */
	transition: background-color 0.3s ease, transform 0.2s ease, box-shadow
		0.2s ease;
	text-transform: uppercase;
	/* Make text uppercase for a professional look */
	letter-spacing: 0.5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* Subtle shadow */
}

/* Hover Effect */
.menu-item-card form input[type="submit"]:hover {
	background-color: #c92f39; /* Slightly darker red on hover */
	transform: translateY(-2px); /* Slight lift effect */
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.25);
	/* Enhanced shadow on hover */
}

.menu-item-card form input[type="submit"]:active {
	background-color: #b02932; /* Even darker red when clicked */
	transform: translateY(0); /* Button "sinks" back down */
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2); /* Smaller shadow */
}

/* Focus State (for accessibility, e.g., tab navigation) */
.menu-item-card form input[type="submit"]:focus {
	outline: none; /* Remove default outline */
	box-shadow: 0 0 0 3px rgba(226, 55, 68, 0.4); /* Custom focus ring */
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

			<li><a href="<%=request.getContextPath() %>/Home1.jsp">Home</a></li>

			<li><a href="Home1.jsp">Restaurants</a></li>

			<li><a href="#">Offers</a></li>

			<li><a href="#">Sign In</a></li>

			<li><a href="#">Sign Up</a></li>

		</ul>

	</nav>

	<main class="menu-container">



		<section class="menu-category">

			<h2>Today's Menu</h2>

			<div class="menu-grid">


				<%

ArrayList<Menu> allMenu=( ArrayList<Menu>)request.getAttribute("allMenuByRestaurent");

for(Menu x:allMenu){


%>





				<div class="menu-item-card">

					<div class="item-image-container">

						<img
							src="<%=request.getContextPath() %>/images/<%=x.getImagePath() %>"
							alt="Butter Chicken">

					</div>

					<div class="item-details">

						<h3 class="item-name"><%=x.getItemName() %></h3>

						<p class="item-description"><%=x.getDescription() %></p>

						<div class="item-price">
							₹
							<%=x.getPrice() %></div>

						<form action="cart">

							<input type="hidden" name="itemId" value="<%= x.getMenuId() %>">

							<input type="hidden" name="itemName"
								value="<%= x.getItemName() %>"> <input type="hidden"
								name="quantity" value="1"> <input type="hidden"
								name="price" value="<%= x.getPrice() %>"> <input
								type="hidden" name="restaurentId"
								value="<%= x.getRestaurantId() %>"> <input type="hidden"
								name="action" value="add"> <input id="AddToCart"
								type="submit" value="Add To Cart">






						</form>

					</div>


				</div>

				<% } %>


			</div>

		</section>

	</main>








</body>

</html>