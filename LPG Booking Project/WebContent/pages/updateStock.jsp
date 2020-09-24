<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theater List</title>
<link type="text/css" rel="stylesheet" href="css/design.css" />
<script src="js/validation.js"></script>
</head>
<body style="background-color: lightblue;">
	<div>
		<h2>Update LPG Stock</h2>
		<hr>
		<form method="post" action="LPGController" onsubmit="return checkQty()">
		LPG Provider: <input type="text" name="updatedBy" value="${sessionScope.updatedBy}" readonly="readonly" /><BR>
		Available quantity: <input type="text" name="avQty" value="${sessionScope.avQty}" readonly="readonly" /><BR>		
		Enter Quantity to consume : <input type="text" name="qtyConsume"/><BR>
		<input type="submit" value="Update Stock" name="action"/> 
	</form>
	</div>
</body>
</html>