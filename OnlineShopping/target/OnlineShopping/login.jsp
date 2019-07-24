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
<br><br><br>

	
	<form action="LoginServlet" method="post">

		<table cellpadding="10" cellspacing="10" border="1" align="center">

			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname"></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="text" name="pass"></td>
			</tr>

			<tr>
				<td><input type="submit" Value="Login"></td>
			</tr>

		</table>
	</form>

<br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>