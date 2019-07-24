<%@page import="com.onlineShopping.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<%List<User> ul=(List<User>) session.getAttribute("ulist");
int no=1;
%>
<h1 align="center" style=" color: blue">All Users List</h1>

	<table cellpadding="10" cellspacing="10" border="4" align="center">
		<tr>
			<th>Sr. No.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Contact</th>
			<th>EmailId</th>
			<th>Address</th>
			<th colspan="1">Action</th>
		</tr>

		<tr>
			<%for(User u:ul){ %>
				<td><%=no++ %></td>
				<td><%=u.getFname() %></td>
				<td><%=u.getLname() %></td>
				<td><%=u.getContact() %></td>
				<td><%=u.getEmailId() %></td>
				<td><%=u.getAddress() %></td>
				<td><a href="deleteUser">Delete</a></td>
			
		</tr>
		<%} %>
	</table>
	<br><br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>