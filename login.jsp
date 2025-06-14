<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	padding: 0;
	background-color: lightSkyBlue;
	background-size: cover;
}

.login-container {
	width: 360px;
	margin: 100px auto;
	padding: 30px 25px;
	background: rgba(255, 255, 255, 0.95);
	border-radius: 15px;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

input[type="email"], input[type="password"] {
	width: 100%;
	padding: 12px 15px;
	margin: 10px 0 20px 0;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-sizing: border-box;
	font-size: 16px;
}

input[type="submit"] {
	width: 100%;
	padding: 12px 15px;
	border: none;
	background-color: #28a745;
	color: white;
	font-size: 16px;
	font-weight: bold;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #218838;
}

.error-message {
	color: red;
	text-align: center;
	margin-bottom: 10px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', sans-serif;
}

body, html {
	height: 100%;
	width: 100%;
}

.animated-bg {
	height: 100vh;
	width: 100%;
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
	display: flex;
	justify-content: center;
	align-items: center;
}

@
keyframes gradient { 0% {
	background-position: 0% 50%;
}

50
%
{
background-position
:
100%
50%;
}
100
%
{
background-position
:
0%
50%;
}
}
.login-container {
	background-color: rgba(255, 255, 255, 0.15);
	padding: 30px;
	border-radius: 20px;
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(10px);
	-webkit-backdrop-filter: blur(10px);
	text-align: center;
}

.login-container input {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border: none;
	border-radius: 8px;
	outline: none;
}

.login-container button {
	background-color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	font-weight: bold;
	transition: background 0.3s ease;
}

.login-container button:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>
	<div class="animated-bg">
		<div class="login-container">
			<h2>Login</h2>
			<form action="LoginServlet" method="post">
				<input type="text" name="email" placeholder="Email" required><br>
				<input type="password" name="password" placeholder="Password"
					required><br>
				<button type="submit">Login</button>
			</form>
		</div>
	</div>
</body>
</html>