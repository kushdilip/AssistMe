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


	<h2>Registration Form</h2>
	<form:form method="POST" commandName="user">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input path="emailId" /></td>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" type="password"/></td>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Add" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="button"
					value="Cancel" onClick="window.location.href='index.html'"></td>
			</tr>

		</table>

	</form:form>
</html>