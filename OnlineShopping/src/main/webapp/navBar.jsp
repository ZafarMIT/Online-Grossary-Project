<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="resources/css/bts.css" rel="stylesheet">

<link href="resources/css/myApp.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<%String userName=(String)session.getAttribute("userName");
		String adminName=(String)session.getAttribute("adminName");
		%>

				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span>
				</a></li>
	
				<li class="nav-item"><a class="nav-link" href="searchProduct.jsp">Search
						Product</a></li>

				<%if(userName==null && adminName==null){ %>

				<li class="nav-item"><a class="nav-link" href="addUser.jsp">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>

				<% }%>


				<%if(userName!=null && adminName==null){ %>
				<li class="nav-item"><a class="nav-link" href="UserServlet?action=editProfile">EditProfile</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="CartServlet">AddToCart</a>
				</li>

				<%} %>


				<%if(userName==null && adminName!=null){ %>

				<li class="nav-item"><a class="nav-link" href="UserServlet">UserList</a></li>

				<li class="nav-item"><a class="nav-link" href="addProduct.jsp">AddProduct</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="CartServlet?action=olist">OrderList</a>
				</li>
				<%} %>

				<li class="nav-item"><a class="nav-link" href="contactUs.jsp">Contact</a></li>

				<%  if(adminName!=null || userName!=null){%>

				<li class="nav-item"><a class="nav-link" href="LoginServlet">LogOut</a></li>
				<%} %>

			</ul>
		</div>
	</div>
</nav>

<br>
<br>