<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p align="center">
		<a href="showImportantDates.html">Go to important Date list</a>
	</p>

	<h2>Add Anniversary</h2>
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
				<td>Recurring :</td>
		</table>
	</form:form>
</body>
</html>