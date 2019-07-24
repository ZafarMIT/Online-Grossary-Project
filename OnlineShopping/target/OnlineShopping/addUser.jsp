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
	<jsp:include page="navBar.jsp"></jsp:include>

	<c:if test="${cpass!=null }">
	<c:out value="">${cpass }</c:out>
	</c:if>

	<form action="UserServlet" method="post">

		<table cellpadding="10" cellspacing="10" border="6" align="center">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>


			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>

			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact"></td>
			</tr>

			<tr>
				<td>EmailId</td>
				<td><input type="text" name="emailId"></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="text" name="pass"></td>
			</tr>

			<tr>
				<td>Confirm password</td>
				<td><input type="text" name="cpass"></td>
			</tr>
			<tr>
				<td><input type="submit" Value="Save"></td>
			</tr>

		</table>
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>