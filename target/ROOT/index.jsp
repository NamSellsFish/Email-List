<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="./header.html" %>
	<main>
		<!-- Breadcrumb -->
		<div>
		<c:import url="breadcrumb.html" />
		</div>
		<div>
			<h1>Join our email list</h1>
			<p>To join our email list, enter your name and email address
				below.</p>
			<p><i>${message}</i></p>
			<form action="emailList" method="post">
				<input type="hidden" name="action" value="add" /> 
				<label class="pad_top"> Email:</label>
				<input type="text" name="email" value="${user.email}"/><br>
				<label class="pad_top">First Name:</label>
				<input type="text" name="firstName" value="${user.firstName}"/><br>
				<label class="pad_top"> Last Name:</label>
				<input type="text" name="lastName" value="${user.lastName}"/><br>
				<label>&nbsp;</label>
				<input type="submit" value="Join Now" class="margin_left">
			</form>
		</div>
	</main>
<%@ include file ="./footer.jsp" %>