<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="resources/js/calendar.js"></script>
<script type="text/javascript" src=""></script>
<link rel="stylesheet" type="text/css" href="resources/styles/style.css">


</head>
<body>
	<p align="center">
		<a href="showImportantDates.html">Go to important Date list</a>
	</p>

	<h2>Add Anniversary</h2>
	<p id="demo">I should change</p>
	<form:form method="POST" commandName="anniversary">
		<table>
			<tr>
				<td>Title :</td>

			</tr>
			<tr>
				<td>People :</td>
				<td><form:input path="people" /></td>
			</tr>
			<tr>
				<td>Date :</td>
			</tr>


			<tr>
				<td>Recurring :</td>
			</tr>
		</table>
	</form:form>
</body>
</html>