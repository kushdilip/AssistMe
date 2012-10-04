<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="container" style="width: 100%">

		<div id="header" style="background-color: #FFA500;" align="center">
			<h1 style="margin-bottom: 0;">AssistMe</h1>
			<h3>Your own Personal Assistant</h3>
		</div>



		<div id="sidebar" align="left"
			style="background-color: #FFD700; height: 490px; width: 250px; float: right; font-size: large; font-weight: bold;">
			<form action="login.html" method="POST">
				Email Id: <input type="text" name="emailId"><br>
				Password: <input type="password" name="password"> <input
					type="submit" value="Submit">
			</form>
			<a href="userRegistration.html"><b>Register</b></a>


		</div>

		<div id="footer"
			style="background-color: #FFA500; clear: both; text-align: center;">
			Copyright © TavantTechnologies.com</div>
	</div>
</body>
</html>