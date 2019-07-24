
<!DOCTYPE html>
<%@page import="com.onlineShopping.daoImpl.ProductDaoImpl"%>
<%@page import="com.onlineShopping.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bts.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/myApp.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<jsp:include page="navBar.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- sideBar -->
			<jsp:include page="sideBar.jsp"></jsp:include>

			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<!-- Slider Page -->
				<jsp:include page="sliderPage.jsp"></jsp:include>

				<div class="row">

					<%String userName=(String)session.getAttribute("userName");
		String adminName=(String)session.getAttribute("adminName");
		%>
					<%
      
      ProductDaoImpl pd=new ProductDaoImpl();
      String category=(String)session.getAttribute("ctg");
      List<Product> pl=null; 
     // out.print(category);
      if(category!=null){
    	  pl=pd.getProductByCategory(category);
      }
      else{
    	  pl=pd.getProductList();
      }
      
      %>




					<%for(Product p:pl){ %>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="resources/image/<%=p.getPname() %>.jpeg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#"><%=p.getPname() %></a>
								</h4>


								<h5><%=p.getPrice() %></h5>
								<%if(userName!=null){ %>
								<h5>
									<a href="CartServlet?action=addToCart&pid=<%=p.getPid()%>">addToCart</a>
								</h5>
								<%} %>
								<p class="card-text"><%=p.getpDescription() %></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<%} %>



				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootStrapBundleJs.js"></script>

</body>

</html>
