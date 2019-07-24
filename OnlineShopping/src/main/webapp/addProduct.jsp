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
<br><br>
	<form action="ProductServlet" method="post"  enctype="multipart/form-data">
		<table cellpadding="10" cellspacing="10" border="4" align="center">


			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname" required></td>
			</tr>


			<tr>
				<td>Category</td>
				<td><select name="category">
						<option value="Vivo">Vivo Mobiles</option>
						<option value="Oppo">Oppo Mobiles</option>
						<option value="MI">MI Mobiles</option>
						<option value="Sumsung">Sumsung Mobiles</option>
				</select></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><input type="text" name="price" required></td>
			</tr>

			<tr>
				<td>Select File:</td>
				<td><input type="file" name="img"  /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="pdescriptiom" required></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>


		</table>
	</form>
<br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>