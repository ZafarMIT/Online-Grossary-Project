<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
---- Include the above in your HEAD tag -------- -->

<%@page import="com.onlineShopping.daoImpl.CartDaoImpl"%>
<%@page import="com.onlineShopping.daoImpl.UserDaoImpl"%>
<%@page import="com.onlineShopping.pojo.User"%>
<%@page import="java.util.Date"%>
<jsp:include page="navBar.jsp"></jsp:include>
<%
UserDaoImpl ud=new UserDaoImpl();
CartDaoImpl cd=new CartDaoImpl();

String price[]=(String[]) session.getAttribute("price");
String qty[]=(String[]) session.getAttribute("qty");
Double totalBill=(Double)session.getAttribute("totalBill");
String pname[]=(String[])session.getAttribute("pname");
String userName=(String )session.getAttribute("userName");
cd.clearCart(userName);
User u=ud.getUserByName(userName);

%>
<div class="container">

	<div class="row">
		<div
			class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<address>
						<strong><%=u.getFname()+"   "+u.getLname() %></strong> <br> <%=u.getEmailId() %> <br>
						<%=u.getAddress() %> <br> <abbr title="Phone">P:</abbr> <%=u.getContact() %>
					</address>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 text-right">
					<p>
						<em>Date: <%=new Date().toString() %></em>
					</p>
					<p>
						<em>Receipt #:<%=34522677+totalBill%></em>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="text-center">
					<h1>Receipt</h1>
				</div>
				</span>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>

							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
						</tr>
					</thead>
					<tbody>
						<%for(int i=0;i<price.length;i++){ %>
						<tr>
							<td class="col-md-9"><em><%=pname[i] %></em>
								</h4></td>
							<td class="col-md-1" style="text-align: center"><%=qty[i] %>
							</td>
							<td class="col-md-1 text-center"><%=price[i] %></td>
							<td class="col-md-1 text-center"><%=Integer.parseInt(qty[i])*Double.parseDouble(price[i]) %></td>
						</tr>
						<%} %>
						<tr>
							<td> </td>
							<td> </td>
							<td class="text-right">
								<p>
									<strong>Subtotal: </strong>
								</p>
								<p>
									<strong>Tax: </strong>
								</p>
							</td>
							<td class="text-center">
								<p>
									<strong><%=totalBill %></strong>
								</p>
								<p>
									<strong><%=totalBill*0.05 %></strong>
								</p>
							</td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td class="text-right"><h4>
									<strong>Total: </strong>
								</h4></td>
							<td class="text-center text-danger"><h4>
									<strong><%=totalBill+(totalBill*0.05 ) %></strong>
								</h4></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>