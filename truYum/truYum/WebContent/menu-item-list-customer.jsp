<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a href="ShowCart">Cart</a><a
			href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<h3 style="margin-left: 118px">Products</h3>
	<c:if test="${addCartStatus}">
		<div class="success-message">Item added to Cart Successfully.</div>
	</c:if>
	<table class="body-content-colour">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td>${menuItem.price}</td>
					<td>${menuItem.category}</td>
					<td><a href="AddToCart?id=${menuItem.id}" style="color: black">Add
							to Cart</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<div class="footer">
		<p>copyright @ 2019</p>
	</div>
</body>
</html>