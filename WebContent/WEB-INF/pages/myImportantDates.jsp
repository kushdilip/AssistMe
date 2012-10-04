<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
			<p>
			Welcome User: ${currentUser.firstName}
			</p>
			<h3 align="center">my important dates</h3>
			<a href="importantDates.html">Refresh List</a> <br> <br>
			<table border="1" bordercolor="black">
				<thead>
					<tr>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${anniversaryList}" var="anvrsry" varStatus="loop">

						<tr>
							<td><c:out value="${loop.index + 1}" /></td>
							<td><c:out value="${anvrsry.title}" /></td>
							<td><c:out value="${anvrsry.date}" /></td>
							<td><c:out value="${anvrsry.people}" /></td>
							<td><a
								href="deleteAnniversary.html?anniversaryId=${anvrsry.anniversaryId}&anniversaryTitle=${anvrsry.title}">delete</a>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
		</div>
	
</body>
</html>