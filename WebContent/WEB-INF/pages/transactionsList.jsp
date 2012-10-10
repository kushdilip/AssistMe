<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/menubar.jsp"></jsp:include>

	<div id="container" align="center"></div>

	<div id="addMenu" align="center">
		<br>
		<table>
			<tr>
				<td>Add New:</td>
				<td><button
						onclick="window.location.href='transaction-add.html?owes=I'">I
						owe someone</button></td>
				<td><button
						onclick="window.location.href='transaction-add.html?owes=someone'">Someone
						owes me</button></td>
			</tr>
		</table>



	</div>
	<div align="center">
		<h3 align="center">Bills and Transactions</h3>

		<table border="1">
			<tbody>
				<c:forEach items="${transactionList}" var="trnsction"
					varStatus="loop">
					<c:set var="owingStatement" value="I owe ${trnsction.contactName}" />
					<c:set var="owingCash" value=" ${trnsction.amount}" />

					<c:if test="${trnsction.amount < 0 }">
						<c:set var="owingStatement"
							value="${trnsction.contactName} Owes Me" />
						<c:set var="owingCash" value="${-trnsction.amount}" />
					</c:if>

					<tr>
						<td><c:out value="${owingStatement}" /></td>
						<td>&#8377;<c:out value="${owingCash}" /></td>
						<td style="font-weight: bold">for <c:out
								value="${trnsction.description}" /></td>
						<td><a href="delete-transaction.html?transId=${trnsction.id}">delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>