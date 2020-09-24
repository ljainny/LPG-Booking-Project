<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List Page</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link type="text/css" rel="stylesheet" href="css/design.css" />
<script src="js/validation.js"></script>
</head>
<body style="background-color: lightblue">
	<div>
		<h3>Location of different LPG service providers</h3>
		<hr>
		<form action="LPGController">
			Select Location: <select name="location">
				<option value="">Pls Select Location:</option>
				<option value="Pune">Pune</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Bangalore">Bangalore</option>
			</select> <BR> <input type="submit" value="getStock" name="action">
		</form>
		<c:set var="stockList" value="${stockList}"></c:set>
		<c:if test="${!empty stockList }">
			<form>
				<table border="1">
					<tr>
						<th>Average Stock</th>
						<th>LPG Provider</th>
						<th>Location</th>
						<th>Show Consumption</th>
					</tr>
					<c:forEach items="${stockList}" var="stock">
						<tr>
							<td>${stock.avQty}</td>
							<td>${stock.updatedBy}</td>
							<td>${stock.location}</td>
							<td><c:if test="${stock.avQty > 0}">
									<a
										href="LPGController?action=consumeNow&updatedBy=${stock.updatedBy}&avQty=${stock.avQty}">
										Consume Now</a>
								</c:if> <c:if test="${stock.avQty == 0}">
					No LPG Stock
				</c:if></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</c:if>
	</div>
</body>
</html>