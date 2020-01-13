<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<form action="ShowMoviesListAdmin" method="get">
		<div class="topnav">
			<div class="home">Movie Cruiser</div>
			<img src="images/film logo.png"> <a href="ShowMoviesListAdmin">Movies</a>
		</div>
		<h3 style="margin-left: 130px">Movies</h3>
		<table class="body-content-colour">
			<tr>
				<th>Title</th>
				<th>Gross</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td>$<fmt:formatNumber value="${movies.gross}"
							pattern="#,##,##,##,###.00" /></td>
					<td><c:choose>
							<c:when test="${movies.active eq true}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern='dd/MM/yyyy'
							value="${movies.dateOfLaunch}" /></td>
					<td>${movies.genre}</td>
					<td><c:choose>
							<c:when test="${movies.teaser eq true}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a style="color: black"
						href="ShowEditMovies?id=${movies.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<p>Copyright @ 2019</p>
		</div>
	</form>
</body>
</html>