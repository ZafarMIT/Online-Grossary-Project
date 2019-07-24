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
<input type="hidden" name="action" value="addUser"> 
		<table cellpadding="10" cellspacing="10" border="6" align="center">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" required></td>
			</tr>


			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" required></td>
			</tr>

			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact" required></td>
			</tr>

			<tr>
				<td>EmailId</td>
				<td><input type="email" name="emailId" required></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><textarea rows="4" cols="22" name="address" required></textarea></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="password" name="pass" required></td>
			</tr>

			<tr>
				<td>Confirm password</td>
				<td><input type="password" name="cpass" required></td>
			</tr>
			<tr>
				<td><input type="submit" Value="Save"></td><td ><input type="reset" Value="reset"></td>
			</tr>

		</table>
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>