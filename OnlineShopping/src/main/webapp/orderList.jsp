<%@page import="com.onlineShopping.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<%List<Order> olist=(List<Order>)session.getAttribute("olist");
int no=1;
%>

<table cellpadding="10" cellspacing="10" border="6" align="center">

<tr>
<th>Sr. No.</th>
<th>UserName</th><th>OrderStatus</th><th>OrderDate</th><th>TotalBill</th>


</tr>
<%for(Order o:olist){ %>
<tr>
<td><%=no++ %></td>
<td><%=o.getUserName() %></td>
<td><%=o.getStatus() %></td>
<td><%=o.getOrderDate() %></td>
<td><%=o.getTotalBill() %></td>
</tr>
<%} %>
</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>