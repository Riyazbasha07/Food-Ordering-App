<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - FoodApp</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">
<style>
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
	background: linear-gradient(-45deg, #ff6b6b, #f06595, #845ef7, #5c7cfa);
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
	padding: 30px 40px;
	border-radius: 20px;
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(10px);
	-webkit-backdrop-filter: blur(10px);
	text-align: center;
	width: 300px;
}

.login-container h2 {
	margin-bottom: 20px;
	color: white;
}

.login-container input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: none;
	border-radius: 8px;
	outline: none;
}

.login-container button {
	background-color: #ffffff;
	color: #333;
	padding: 10px 20px;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	font-weight: bold;
	margin-top: 10px;
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
			<h2>Register</h2>
			<form action="RegisterServlet" method="post">
				<input type="text" name="userName" placeholder="Username" required><br>
				<input type="email" name="email" placeholder="Email" required><br>
				<input type="password" name="password" placeholder="Password"
					required><br> <input type="text" name="phoneNumber"
					placeholder="Phone Number" required><br> <input
					type="text" name="address" placeholder="Address" required><br>
				<button type="submit">Register</button>
			</form>
		</div>
	</div>

	<div class="login-link">
		Already have an account? <a href="login.jsp">Login here</a>
	</div>
	</div>

</body>
</html>