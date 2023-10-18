<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thanks</title>
<link rel="stylesheet" href="./main.css" type="text/css" />
</head>
<body>
	<!-- Breadcrumb -->
	<c:import url="breadcrumb.html" />
	<h1>Thanks for joining our email list</h1>
	<p>Here is the information that you entered</p>
	<label>Email: </label>
	<span>${user.email}</span>
	<br>
	<label>First Name: </label>
	<span>${user.firstName}</span>
	<br>
	<label>Last Name: </label>
	<span>${user.lastName}</span>
	<br>
		<p>This email address was added to our list on ${requestScope.currentDay}/${requestScope.currentMonth}/${requestScope.currentYear}</p>
		
		<p>The first address on our list is ${sessionScope.users[0].email}<br>
			The second address on our list is ${sessionScope.users[1].email}
		</p>
		
		<p>For customer service, contact ${initParam.custServEmail}</p>
	<p>To enter another email address, click on the Back button in your
		browser or the Return button shown below.</p>
	<form action="emailList" >
		<input type="hidden" name="action" value="join" />
		<input type="submit" value="Return">
	</form>
<c:import url="./footer.jsp" />
