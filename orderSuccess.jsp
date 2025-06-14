<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Order Success</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #e0ffe0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.success-container {
	background: #ffffff;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.success-container h2 {
	color: #28a745;
	margin-bottom: 15px;
}

.success-container p {
	color: #333;
	font-size: 18px;
}

.success-container a {
	display: inline-block;
	margin-top: 20px;
	padding: 12px 20px;
	background-color: #28a745;
	color: white;
	text-decoration: none;
	border-radius: 6px;
	font-weight: bold;
}

.success-container a:hover {
	background-color: #218838;
}
</style>
</head>
<body>

	<div class="success-container">
		<h2>Order Placed Successfully!</h2>
		<p>Thank you for ordering. Your delicious food will be delivered
			soon.</p>
		<a href="HomeServlet">Go to Home</a>
	</div>

</body>
</html>