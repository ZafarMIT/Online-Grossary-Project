<%@page import="com.onlineShopping.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<jsp:include page="navBar.jsp"></jsp:include>
	<%
		List<Cart> cl = (List<Cart>) session.getAttribute("cartList");

		int no = 1;
	%>
	<form action="CartServlet" method="post">
		<input type="hidden" name="action" value="cartList"> 
		<table cellpadding="10" cellspacing="10" border="4" align="center">
	
			<tr>
				<th>Sr.No.</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Delete</th>
			</tr>
			<%
				for (Cart c : cl) {
			%>
			<tr>
				<td><%=no++%></td>
				<td><%=c.getPname()%></td>
				<input type="hidden" name="pname" value="<%=c.getPname()%>">
				<td><textarea rows="8" cols="30" readonly="readonly"><%=c.getPdescription()%></textarea></td>
				<td><%=c.getPrice()%></td>
				<input type="hidden" name="price" value="<%=c.getPrice()%>">
				<td><input type="number" name="qty" id="qty" value="1"></td>
				<td><a href="CartServlet?action=delete&cid=<%=c.getCartId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
			<tr>
			<td colspan="5" align="center"><Input type="submit" value="Place Order"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>